package dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.bean.Participater;
import pojo.bean.Pictures;

import java.util.List;
import java.util.Map;

/**
 * @author DAHUANG
 * @description
 * @date 9/10/2021 19:08
 */
public interface ActivityDao {

    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------

    //-----------------------------------分割线---------上面是需要新增的方法-----------------------------
    //-----------------------------------------------------------------------------------------------
    /**
     * 根据名字查看活动是否存在
     * @param name
     * @return 返回名称中含有name的活动
     */
    boolean checkActivityExist(@Param("name") String name);

    /**
     * 模糊查询组织
     * @param name
     * @return
     */
    List<Organizer> getOrgSearch(@Param("nameSer")String name);

    /**
     * 模糊查询活动
     * @param name
     * @return
     */
    List<ActivityUser> getActSearch(@Param("nameSer")String name);

    /**
     *通过id查询个人活动（非组织）
     * @param id
     * @return
     */
    ActivityUser selectInfoById(@Param("id") Integer id);

    /**
     * 通过活动组织者学号查找活动
     * @param organizer
     * @return
     */
    List<ActivityUser> selectActivitiesByOrganizer(@Param("org") Integer organizer);

    /**
     *
     * @param organizer
     * @return
     */
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

    /**
     * 添加活动的具体内容信息（不包括图片）
     * @param id
     * @param info
     */
    void addActivityInfo(@Param("id") Integer id,@Param("info") String info);

    /**
     * 为活动添加图片
     * @param id
     * @param picture
     */
    void addActivityPicture(@Param("id") Integer id,@Param("basecode") String picture);

    /**
     * 查询活动的所有图片
     * @param id
     * @return
     */
    List<Pictures> selectPicturesById(@Param("id") Integer id);

    /**
     *得到头像
     * @param id
     * @return 返回头像所存储的照片
     */
    String getHeadPortrait(@Param("id") Integer id);

    /**
     * 添加组织图片
     * @param pic
     */
    void addHeadPortrait(@Param("baseCode")String pic,@Param("id") Integer id);

    /**
     * 一次性查询多个活动，具体取决于页面，limit
     * select *from activity_organization where 1=1 order by id asc limit #{num}
     * @param number1 从num1+1行开始
     * @param number2 找到多少行数据 如select * from student limit 2,8;  返回3到10行记录
     * @return
     */
    List<ActivityUser> getActivity(@Param("num1") Integer number1,@Param("num2") Integer number2);

    /**
     * 得到活动的状态
     * @param id
     * @return
     */
    String getStatus(@Param("id") Integer id);

    /**
     * 更新活动状态,将活动的状态由true改成false
     * @param id
     */
    void upStatus(@Param("id")Integer id);

    /**
     * 获得某一张活动的图片，用于轮播图
     * @param id
     * @return
     */
    String getCarouselPic(@Param("id") Integer id);

    /**
     * 插入活动的主照片
     * @param id
     * @param picture
     * @return
     */
    void setActMainPic(@Param("id") Integer id,@Param("mainPic") String picture);

    /**
     * 得到活动的主照片
     * @param id
     * @return
     */
    Pictures getActMainPic(@Param("id")Integer id);

    /**
     * 统计活动个数
     * @return
     */
    Integer countAllAct();

    /**
     *获得活动的类型，0为体育活动，1为学术活动，2为志愿活动
     * @param id
     * @return
     */
    Integer getLevelByID(@Param("id") Integer id);
}
