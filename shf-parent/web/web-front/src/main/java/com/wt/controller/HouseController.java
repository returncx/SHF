package com.wt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.wt.entity.*;
import com.wt.result.Result;
import com.wt.service.*;
import com.wt.vo.HouseQueryVo;
import com.wt.vo.HouseVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/house")
@CrossOrigin
@SuppressWarnings({"unchecked", "rawtypes"})
public class HouseController {

    @Reference
    private HouseService houseService;


    @Reference
    private CommunityService communityService;

    @Reference
    private DictService dictService;

    @Reference
    private HouseImageService houseImageService;

    @Reference
    private HouseBrokerService houseBrokerService;

    @Reference
    private UserFollowService userFollowService;

    /**
     * 房源列表
     *
     * @return
     */
    @RequestMapping(value = "/list/{pageNum}/{pageSize}")
    public Result findListPage(@RequestBody HouseQueryVo houseQueryVo,
                               @PathVariable Integer pageNum,
                               @PathVariable Integer pageSize) {
        PageInfo<HouseVo> pageInfo = houseService.findListPage(pageNum, pageSize, houseQueryVo);
        return Result.ok(pageInfo);
    }

    @GetMapping("info/{id}")
    public Result info(@PathVariable Long id, HttpServletRequest request) {
        House house = houseService.getById(id);
        Community community = communityService.getById(house.getCommunityId());
        List<HouseBroker> houseBrokerList = houseBrokerService.findListByHouseId(id);
        List<HouseImage> houseImage1List = houseImageService.findList(id, 1);

        Map<String, Object> map = new HashMap<>();
        map.put("house",house);
        map.put("community",community);
        map.put("houseBrokerList",houseBrokerList);
        map.put("houseImage1List",houseImage1List);

        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("USER");
        Boolean isFollow = false;
        if(null != userInfo) {
            Long userId = userInfo.getId();
            isFollow = userFollowService.isFollowed(userId, id);
        }
        map.put("isFollow",isFollow);

        return Result.ok(map);
    }
}
