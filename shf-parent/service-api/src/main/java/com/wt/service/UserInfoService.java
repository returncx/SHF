package com.wt.service;

import com.wt.entity.UserInfo;


public interface UserInfoService extends BaseService<UserInfo> {

    public UserInfo getByPhone(String phone);

}


