package dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Participater;

import java.util.List;
import java.util.Map;

/**
 * @author DAHUANG
 * @description
 * @date 9/10/2021 19:08
 */
public interface ActivityDao {
    /**
     *通过id查询个人活动（非组织）
     */
    ActivityUser selectInfoById(@Param("id") Integer id);

    /**
     * 通过活动组织者学号查找活动
     */
    List<ActivityUser> selectActivitiesByOrganizer(@Param("org") Integer organizer);

    @MapKey("name")
    Map<String,ActivityUser> selectActivitiesByOrganizerReturnMap(@Param("org") Integer organizer);

    /**
     * 活动时间设置需要设置时间格式 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
     * 或者传入的日期格式为 yyyy-mm-dd 例如（2021-10-07）
     * @param activity
     */
    void addActivity(ActivityUser activity);

    /**
     * 根据id删除活动
     * @param id
     */
    void deleteActivity(Integer id);

    /**
     * 通过活动id查找参加活动的学生
     * @param id
     * @return
     */
    List<Participater> selectStudentsByArtId(@Param("id") Integer id);

    /**
     * 找到包含参赛人员的所有信息的比赛信息
     * @param id 要查询的比赛的id
     * @return
     */
    List<ActivityUser> selectInfoIncludePars(Integer id);
}
