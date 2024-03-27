package com.wt.dao;

import com.github.pagehelper.Page;
import com.wt.entity.House;
import com.wt.vo.HouseQueryVo;
import com.wt.vo.HouseVo;
import org.apache.ibatis.annotations.Param;

public interface HouseDao extends BaseDao<House>{

    Page<HouseVo> findListPage(@Param("vo") HouseQueryVo houseQueryVo);


}
