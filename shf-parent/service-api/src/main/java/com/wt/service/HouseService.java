package com.wt.service;

import com.github.pagehelper.PageInfo;
import com.wt.entity.House;
import com.wt.vo.HouseQueryVo;
import com.wt.vo.HouseVo;

public interface HouseService extends BaseService<House> {


    void publish(Long id, Integer status);

    PageInfo<HouseVo> findListPage(int pageNum, int pageSize, HouseQueryVo houseQueryVo);
}
