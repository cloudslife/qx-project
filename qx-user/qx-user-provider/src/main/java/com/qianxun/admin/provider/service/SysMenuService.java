package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuSearchByIdDTO;
import com.qianxun.admin.api.entity.SysMenu;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysMenuService extends IService<SysMenu> {

    SysMenuDTO searchById(SysMenuSearchByIdDTO inputDTO);

    Boolean saveSysMenu(SysMenuDTO sysMenuDTO);

    IPage getSysMenus(Page page, SysMenuQueryInputDTO inputDTO);

    Boolean updateSysMenu(SysMenuDTO sysMenuDTO);

    List<SysMenuDTO> getMenusByRoleId(Integer roleId);

    List<SysMenuDTO> getMenusByUserId(Integer userId);

    /**
     * 获取包含国际化信息的角色权限
     * @param roleId
     * @return
     */
    List<SysMenuDTO> getMenusWithLangByRoleId(Integer roleId, Integer langId);

    /**
     * 获取用户的所有权限（自己+角色）
     * @param userId
     * @return
     */
    List<SysMenuDTO> getUserMenusWithLang(Integer userId, Integer langId);
}
