package com.wt.service;

import com.wt.entity.HouseImage;

import java.util.List;

public interface HouseImageService extends BaseService<HouseImage> {
    List<HouseImage> findList(Long houseId, Integer type);
}
