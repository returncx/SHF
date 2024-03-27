package com.wt.service;

import com.github.pagehelper.PageInfo;
import com.wt.entity.UserFollow;
import com.wt.vo.UserFollowVo;

public interface UserFollowService extends BaseService<UserFollow>{
    void follow(Long userId, Long houseId);


    Boolean isFollowed(Long userId, Long houseId);

    PageInfo<UserFollowVo> findListPage(int pageNum, int pageSize, Long userId);

    void cancelFollow(Long id);
}
