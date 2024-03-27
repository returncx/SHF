package com.wt.service;

import com.wt.entity.HouseUser;

import java.util.List;

public interface HouseUserService extends BaseService<HouseUser>  {
    List<HouseUser> findListByHouseId(Long id);
}
