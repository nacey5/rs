package service;

import pojo.bean.ActivityUser;
import pojo.bean.Participater;
import pojo.bean.Pictures;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 16:01
 */
public interface ActivityService {
    /**
     * 增加活动
     *
     * @param activityUser
     */
    void addActivity(ActivityUser activityUser);

    /**
     * 删除活动
     *
     * @param id
     */
    void deleteActivityById(Integer id);

    /**
     * 修改活动
     *
     * @param id
     * @param activityUser
     */
    void updateActivityById(Integer id, ActivityUser activityUser);

    /**
     * 查询活动
     *
     * @param id
     * @return
     */
    ActivityUser selectActivity(Integer id);

    /**
     * 根据名字查看活动是否存在
     * @param name
     * @return
     */
    boolean checkActivityName(String name);
    /**
     * 添加活动图片（base64编码形式）
     *
     * @param id
     * @param pic
     */
    void addPicture(Integer id, String pic);

    /**
     * 查找活动图片
     *
     * @param id
     * @return
     */
    List<Pictures> getPicture(Integer id);

    /**
     * 通过活动id查询对应参加的学生
     *
     * @param id
     * @return
     */
    List<Participater> selectStudentInActivity(Integer id);

    /**
     * 一次性查询几个（具体看设计图）活动(用于展示在赛事活动页面)
     * @param start
     * @param end
     * @return
     */
    List<ActivityUser> getActivity(int start,int end);

    /**
     * 添加活动的具体内容信息
     * @param id
     * @param info
     */
    void addActivityInfo(Integer id, String info);
    /**
     * 通过活动组织者学号查找活动
     * @param organizer
     * @return
     */
    List<ActivityUser> selectActivitiesByOrganizer(Integer organizer);
    /**
     * 找到包含参赛人员的所有信息的比赛信息
     * @param id 要查询的比赛的id
     * @return
     */
    List<ActivityUser> selectInfoIncludePars(Integer id);

//    /**
//     *查询分页的活动
//     * @param pageNo 页码
//     * @param pageSize 当前页显示数量
//     * @param id  用户id
//     * @return 查询到的博客
//     */
//    PageBO<ActivityUser> page(int pageNo, int pageSize, Integer id);

    /**
     * 通过活动名称查询活动
     * @param searchText
     * @return
     */
    List<ActivityUser> searchActivityByName(String searchText);
//    /**
//     *查询分页的活动
//     * @param pageNo 页码
//     * @param pageSize 当前页显示数量
//     * @param id  用户id
//     * @return 查询到的博客
//     */
//    PageBo<ActivityUser> page(int pageNo, int pageSize, Integer id);
}
