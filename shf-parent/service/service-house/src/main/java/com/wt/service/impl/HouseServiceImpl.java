package com.wt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.dao.BaseDao;
import com.wt.dao.DictDao;
import com.wt.dao.HouseDao;
import com.wt.entity.House;
import com.wt.service.DictService;
import com.wt.service.HouseService;
import com.wt.vo.HouseQueryVo;
import com.wt.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service(interfaceClass = HouseService.class)
@Transactional
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {


    @Autowired
    private HouseDao houseDao;

    @Autowired
    private DictService dictService;

    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<House> getEntityDao() {
        return houseDao;
    }

    @Override
    public void publish(Long id, Integer status) {
        House house = new House();
        house.setId(id);
        house.setStatus(status);
        houseDao.update(house);
    }

    @Override
    public PageInfo<HouseVo> findListPage(int pageNum, int pageSize, HouseQueryVo houseQueryVo) {
        PageHelper.startPage(pageNum, pageSize);
        Page<HouseVo> page = houseDao.findListPage(houseQueryVo);
        List<HouseVo> list = page.getResult();
        for(HouseVo houseVo : list) {
            //户型：
            String houseTypeName = dictDao.getNameById(houseVo.getHouseTypeId());
            //楼层
            String floorName = dictDao.getNameById(houseVo.getFloorId());
            //朝向：
            String directionName = dictDao.getNameById(houseVo.getDirectionId());
            houseVo.setHouseTypeName(houseTypeName);
            houseVo.setFloorName(floorName);
            houseVo.setDirectionName(directionName);
        }
        return new PageInfo<HouseVo>(page, 10);
    }

    @Override
    public House getById(Serializable id) {
        House house = houseDao.getById(id);
        if(null == house) return null;

        //户型：
        String houseTypeName = dictService.getNameById(house.getHouseTypeId());
        //楼层
        String floorName = dictService.getNameById(house.getFloorId());
        //建筑结构：
        String buildStructureName = dictService.getNameById(house.getBuildStructureId());
        //朝向：
        String directionName = dictService.getNameById(house.getDirectionId());
        //装修情况：
        String decorationName = dictService.getNameById(house.getDecorationId());
        //房屋用途：
        String houseUseName = dictService.getNameById(house.getHouseUseId());

        house.setHouseTypeName(houseTypeName);
        house.setFloorName(floorName);
        house.setBuildStructureName(buildStructureName);
        house.setDirectionName(directionName);
        house.setDecorationName(decorationName);
        house.setHouseUseName(houseUseName);

        return house;
    }
}
