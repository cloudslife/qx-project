package com.qianxun.admin.api.dto.sysRole.response;

import com.qianxun.admin.api.entity.SysRole;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 *  */
@Data
public class SysRoleResponseDTO implements Serializable {
    /**
     * 总记录数
     * 需要加上默认为0，避免传回前端连字段都没有
     */
    private Integer total = 0;

    /**
     * 分页查询结果
     * 需初始化，避免传回前端无字段
     */
    private List<SysRole> sysRoles = new ArrayList<>();
}
