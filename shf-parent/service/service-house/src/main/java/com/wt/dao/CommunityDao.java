package com.wt.dao;

import com.wt.entity.Community;

import java.util.List;

public interface CommunityDao extends BaseDao<Community> {

    List<Community> findAll();
}
