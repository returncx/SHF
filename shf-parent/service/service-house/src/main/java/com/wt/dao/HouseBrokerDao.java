package com.wt.dao;

import com.wt.entity.HouseBroker;

import java.util.List;

public interface HouseBrokerDao extends BaseDao<HouseBroker> {

    List<HouseBroker> findListByHouseId(Long houseId);
}
