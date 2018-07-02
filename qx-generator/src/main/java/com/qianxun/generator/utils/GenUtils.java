package com.qianxun.generator.utils;

import com.qianxun.generator.entity.ColumnEntity;
import com.qianxun.generator.entity.TableEntity;
import com.qianxun.generator.utils.exception.RRException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 */
public class GenUtils {
    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
//        templates.add("template/Entity.java.vm");
//        templates.add("template/Dao.java.vm");
//        templates.add("template/Dao.xml.vm");
//        templates.add("template/Service.java.vm");
//        templates.add("template/ServiceImpl.java.vm");
//        templates.add("template/Controller.java.vm");
//        templates.add("template/list.html.vm");
//        templates.add("template/list.js.vm");
//        templates.add("template/menu.sql.vm");
        templates.add("temp/model/entity/Entity.java.vm");
        templates.add("temp/Mapper.java.vm");
        templates.add("temp/Mapper.xml.vm");
        templates.add("temp/Controller.java.vm");
        templates.add("temp/Service.java.vm");
        templates.add("temp/ServiceImpl.java.vm");
        templates.add("temp/model/dto/request/AddInputDTO.java.vm");
        templates.add("temp/model/dto/request/DeleteInputDTO.java.vm");
        templates.add("temp/model/dto/request/QueryInputDTO.java.vm");
        templates.add("temp/model/dto/request/UpdateInputDTO.java.vm");
        return templates;
    }

    /**
     * 生成代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns,
                                     ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            //把数据库的jdbc小写类型，如int,varchar
            columnEntity.setDataType(column.get("dataType"));
            //把数据库的jdbc类型转化为大写，如VARCHAR
            columnEntity.setDataUpperCaseType(column.get("dataType").toUpperCase());
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));
            columnEntity.setNullable(column.get("isNullable"));
            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            //jdbc的大写类型，转化为java的包含包名的类型，如INT=>java.lang.Integer
            String attrAllType = config.getString(columnEntity.getDataUpperCaseType(), "unknowType");
            columnEntity.setAttrAllType(attrAllType);
            //列的数据类型，转换成Java类型(配置文件读)
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrAllType.equals("java.math.BigDecimal")
                    || !hasBigDecimal && attrType.equals("BigDecimal")) {
                hasBigDecimal = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }
            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "com.qianxun" : mainPath;

        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package"));
        map.put("moduleName", config.getString("moduleName"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                //添加到zip
                String name = getFileName(template, tableEntity.getClassName(),
                        tableEntity.getClassname(),
                        config.getString("package"),
                        config.getString("moduleName"));
                zip.putNextEntry(new ZipEntry(name));
                IOUtils.write(sw.toString(), zip, "UTF-8");
//                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
    }

    /**
     * 获取配置信息
     */
    private static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }

    /**
     * 表名转换成Java类名
     */
    private static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 列名转换成Java属性名
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 获取文件名
     */
    private static String getFileName(String template, String className, String classname,
                                      String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
//        if (StringUtils.isNotBlank(packageName)) {
//            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
//        }
//        if (template.contains("Entity.java.vm")) {
//            return packagePath + "entity" + File.separator + className + "Entity.java";
//        }
//        if (template.contains("Dao.java.vm")) {
//            return packagePath + "mapper" + File.separator + className + "Dao.java";
//        }
//        if (template.contains("Service.java.vm")) {
//            return packagePath + "service" + File.separator + className + "Service.java";
//        }
//        if (template.contains("ServiceImpl.java.vm")) {
//            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
//        }
//        if (template.contains("Controller.java.vm")) {
//            return packagePath + "controller" + File.separator + className + "Controller.java";
//        }
//        if (template.contains("Dao.xml.vm")) {
//            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
//        }
//        if (template.contains("list.html.vm")) {
//            return "main" + File.separator + "resources" + File.separator + "templates" + File.separator
//                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".html";
//        }
//        if (template.contains("list.js.vm")) {
//            return "main" + File.separator + "resources" + File.separator + "statics" + File.separator + "js" + File.separator
//                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".js";
//        }
//        if (template.contains("menu.sql.vm")) {
//            return className.toLowerCase() + "_menu.sql";
//        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("Entity.java.vm")) {
            return packagePath + "model" + File.separator + "entity" + File.separator + className + ".java";
        }
        if (template.contains("Mapper.java.vm")) {
            return packagePath + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains("Mapper.xml.vm")) {
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Mapper.xml";
        }
        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }
        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if (template.contains("AddInputDTO.java.vm")) {
            return packagePath + "model" + File.separator + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "AddInputDTO.java";
        }
        if (template.contains("DeleteInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "DeleteInputDTO.java";
        }
        if (template.contains("QueryInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "QueryInputDTO.java";
        }
        if (template.contains("UpdateInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "UpdateInputDTO.java";
        }
        return null;
    }
}
