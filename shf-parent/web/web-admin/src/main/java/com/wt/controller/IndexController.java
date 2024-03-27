package com.wt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wt.entity.Admin;
import com.wt.entity.Permission;
import com.wt.service.AdminService;
import com.wt.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    private final static String PAGE_INDEX ="frame/index";
    private final static String PAGE_MAIN ="frame/main";
    private final static String PAGE_LOGIN="frame/login.html";
    private final static String PAGE_AUTH     = "frame/auth";

    @Reference
    private AdminService adminService;

    @Reference
    private PermissionService permissionService;

    @GetMapping("/")
    public String  index(Map map){

  /*      Long adminId = 10L;
        Admin admin = adminService.getById(adminId);*/

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Admin admin = adminService.getByUsername(user.getUsername());

        List<Permission> permissionList = permissionService.findMenuPermissionByAdminId(admin.getId());

        map.put("admin", admin);
        map.put("permissionList",permissionList);



        return PAGE_INDEX;
    }

    @GetMapping("/main")
    public String main() {

        return PAGE_MAIN;
    }

    @RequestMapping("/login")
    public String  login(){

        return PAGE_LOGIN;

    }
    @GetMapping("/auth")
    public String auth() {
        return PAGE_AUTH;
    }



}
