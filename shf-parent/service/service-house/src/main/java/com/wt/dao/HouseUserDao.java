package com.wt.dao;

import com.wt.entity.HouseUser;

import java.util.List;

public interface HouseUserDao extends BaseDao<HouseUser> {

    List<HouseUser> findListByHouseId(Long houseId);
}
