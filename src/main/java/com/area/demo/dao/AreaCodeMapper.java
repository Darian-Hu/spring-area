package com.area.demo.dao;

import com.area.demo.model.AreaCode;
import com.area.demo.model.AreaCodeExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaCodeMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AreaCodeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(AreaCode record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AreaCode record);

    /**
     *
     * @mbggenerated
     */
    List<AreaCode> selectByExample(AreaCodeExample example);

    /**
     *
     * @mbggenerated
     */
    AreaCode selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AreaCode record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AreaCode record);
}