package com.wt.dao;

import com.wt.entity.Admin;

import java.util.List;

public interface AdminDao extends BaseDao<Admin>{


    List<Admin> findAll();

    Admin getByUsername(String username);
}
