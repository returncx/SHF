package com.wt.service;

import com.wt.entity.Admin;

import java.util.List;

public interface AdminService extends BaseService<Admin> {
    List<Admin> findAll();

    Admin getByUsername(String username);

}
