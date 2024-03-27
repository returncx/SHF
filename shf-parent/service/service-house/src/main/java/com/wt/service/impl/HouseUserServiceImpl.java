package com.wt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wt.dao.BaseDao;
import com.wt.dao.HouseUserDao;
import com.wt.entity.HouseUser;
import com.wt.service.HouseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = HouseUserService.class)
@Transactional
public class HouseUserServiceImpl  extends BaseServiceImpl<HouseUser> implements HouseUserService {



    @Autowired
    private HouseUserDao houseUserDao;

    @Override
    protected BaseDao<HouseUser> getEntityDao() {
        return houseUserDao;
    }

    @Override
    public List<HouseUser> findListByHouseId(Long houseId) {
        return houseUserDao.findListByHouseId(houseId);
    }
}
