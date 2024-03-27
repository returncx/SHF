package com.wt.dao;

import com.wt.entity.Dict;

import java.util.List;

public interface DictDao extends BaseDao<Dict> {

    List<Dict> findListByParentId(Long parentId);

    Integer countIsParent(Long id);


    String getNameById(Long id);

    Dict getByDictCode(String dictCode);
}
