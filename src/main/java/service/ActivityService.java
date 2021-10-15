package service;

import pojo.bean.ActivityUser;

/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 16:01
 */
public interface ActivityService {
    /**
     * 增加活动
     * @param activityUser
     */
    void addActivity(ActivityUser activityUser);

    /**
     * 删除活动
     * @param id
     */
    void deleteActivityById(Integer id);

    /**
     * 修改活动
     * @param id
     * @param activityUser
     */
    void updateActivityById(Integer id,ActivityUser activityUser);

    /**
     * 查询活动
     * @param id
     */
    void selectActivity(Integer id);

}
