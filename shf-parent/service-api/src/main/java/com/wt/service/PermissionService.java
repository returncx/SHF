package com.wt.service;

import com.wt.entity.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService extends BaseService<Permission>{

    /**
     * 根据角色获取授权权限数据
     * @return
     */
    List<Map<String,Object>> findPermissionByRoleId(Long roleId);

    /**
     * 保存角色权限
     * @param roleId
     * @param permissionIds
     */
    void saveRolePermissionRealtionShip(Long roleId, Long[] permissionIds);

    List<Permission> findMenuPermissionByAdminId(Long adminId);

    List<Permission> findAllMenu();

    List<String> findCodeListByAdminId(Long adminId);
}
