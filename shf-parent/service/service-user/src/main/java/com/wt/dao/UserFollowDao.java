package com.wt.dao;

import com.github.pagehelper.Page;
import com.wt.entity.UserFollow;
import com.wt.vo.UserFollowVo;
import org.apache.ibatis.annotations.Param;

public interface UserFollowDao extends BaseDao<UserFollow> {
    Integer countByUserIdAndHouserId(@Param("userId")Long userId, @Param("houseId")Long houseId);
    Page<UserFollowVo> findListPage(@Param("userId")Long userId);
}
