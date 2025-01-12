package com.wt.service;

import com.wt.entity.Dict;

import java.util.List;
import java.util.Map;

public interface DictService {


    public List<Map<String,Object>> findZnodes(Long id);


    /**
     * 根据上级id获取子节点数据列表
     * @param parentId
     * @return
     */
    List<Dict> findListByParentId(Long parentId);

    /**
     * 根据编码获取子节点数据列表
     * @param dictCode
     * @return
     */
    List<Dict> findListByDictCode(String dictCode);


    String getNameById(Long id);

}
