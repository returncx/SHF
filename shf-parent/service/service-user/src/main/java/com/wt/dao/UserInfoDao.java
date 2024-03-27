package com.wt.dao;

import com.wt.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
    public UserInfo getByPhone(String phone);
}
