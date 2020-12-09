package com.sk.mall2.dao;


import com.sk.mall2.entity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMapper {

    /**
     * 删除活动
     *
     * @param activityid 活动id
     * @return int
     */
    int deleteByPrimaryKey(Integer activityid);

    /**
     * 添加活动
     *
     * @param record 活动
     * @return int
     */
    int insertSelective(Activity record);

    /**
     * 获取所有活动
     *
     * @return List<Activity>
     */
    List<Activity> getAllActivity();

    /**
     * 根据id获取活动
     *
     * @param id id
     * @return Activity
     */
    Activity getActivityById(Integer id);
}