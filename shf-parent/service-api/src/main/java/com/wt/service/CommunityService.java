package com.wt.service;

import com.wt.entity.Community;

import java.util.List;

public interface CommunityService extends BaseService<Community> {

        List<Community> findAll();
}
