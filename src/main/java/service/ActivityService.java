package service;

import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Participater;
import pojo.bean.Pictures;
import pojo.bean.User;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 16:01
 */
public interface ActivityService {
    /**
     *通过id查询活动信息
     * @param id
     * @return
     */
    String getInfoById(Integer id);
    /**
     * 查询活动的所有图片
     * @param id
     * @return
     */
    List<Pictures> selectPicturesById(Integer id);
    /**
     * 通过活动id查找出参加的用户
     *
     * @param id
     * @return
     */
    List<User> selectParByActId(Integer id);
    /**
     * 根据名字查询活动
     *
     * @param name
     * @return 返回名称为name的活动
     */
    ActivityUser getActivityByName( String name);
    /**
     * 通过活动id查找参加活动的学生
     * @param id
     * @return
     */
    List<Participater> selectStudentsByArtId( Integer id);
    /**
     * 通过主图片获得活动
     * @param picCode
     * @return
     */
    ActivityUser selectActByMainPic(String picCode);
    /**
     * 得到活动的状态
     * @param id
     * @return
     */
    String getStatus(Integer id);

    /**
     * 更新活动状态,将活动的状态由true改成false
     * @param id
     */
    void upStatus(Integer id);

    /**
     * 插入活动的主照片
     * @param id
     * @param picture
     * @return
     */
    void setActMainPic( Integer id, String picture);

    /**
     * 得到活动的主照片
     * @param id
     * @return
     */
    Pictures getActMainPic(Integer id);
    /**
     * 根据level查询活动，返回该level的所有活动
     * @param level
     * @return
     */
    List<ActivityUser> getActsByLevel(Integer level);
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
     * 添加活动图片
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

    /**
     *
     * @param activityUser
     */
    void addOrgActivity(ActivityUser activityUser);
}
