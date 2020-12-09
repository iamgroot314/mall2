package com.sk.mall2.service;

import com.sk.mall2.entity.Activity;

import java.util.List;

/**
 * @author qiaochx
 */
public interface ActivityService {
    List<Activity> getAllActivity();

    void insertActivitySelective(Activity activity);

    Activity getActivityById(Integer activityid);

    void deleteByActivityId(Integer activityid);

}
