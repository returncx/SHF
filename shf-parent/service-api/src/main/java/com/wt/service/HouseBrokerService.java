package com.wt.service;

import com.wt.entity.House;
import com.wt.entity.HouseBroker;

import java.util.List;

public interface HouseBrokerService extends BaseService<HouseBroker> {
    List<HouseBroker> findListByHouseId(Long id);



}
