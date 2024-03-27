package com.wt.dao;

import com.wt.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao   extends BaseDao<RolePermission> {

    void deleteByRoleId(Long roleId);

    List<Long> findPermissionIdListByRoleId(Long roleId);
}