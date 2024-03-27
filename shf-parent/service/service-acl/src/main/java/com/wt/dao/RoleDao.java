package com.wt.dao;


import com.wt.entity.Role;

import java.util.List;



public interface RoleDao extends BaseDao<Role> {


    List<Role> findAll();



}
