package com.wt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wt.dao.BaseDao;
import com.wt.dao.UserInfoDao;
import com.wt.entity.UserInfo;
import com.wt.service.BaseService;
import com.wt.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = UserInfoService.class)
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    protected BaseDao<UserInfo> getEntityDao() {
        return userInfoDao;
    }

    @Override
    public UserInfo getByPhone(String phone) {



        return userInfoDao.getByPhone(phone);
    }
}
