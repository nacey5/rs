package dao;

import pojo.bean.ActivityUser;
import pojo.bean.User;
import pojo.bean.UserPet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DAHUANG
 * @description
 * @date 8/10/2021 - 15:37
 */
public interface UserDao {
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    /**
     * 根据用户名查询用户信息
     * @param name 用户名
     * @return 返回null表示没有这个用户，反之亦然
     */
    User queryUserByName(@Param("name")String name);

    /**
     * 通过用户id查询当前用户参与的所有活动
     * @param id
     * @return
     */
    List<ActivityUser> selectActListByUserId(Integer id);
  //-----------------------------------分割线*********上面是需要新增的方法************------------------
    // -----------------------------------------------------------------------------------------------

    /**
     * 通过手机号码和密码查询用户
     * @param phone
     * @param password
     * @return
     */
     User selectInfoByPhone(@Param("phone") String phone, @Param("password") String password);

    /**
     * 添加用户
     * @param user
     */
     void addUser(User user);

    /**
     * 通过id添加昵称(√)
     * @param id
     * @param petName
     */
     void addPetName(@Param("id") int id,@Param("petName") String petName);

    /**
     * 通过id查找昵称
     * @param id (√)
     * @return
     */
     UserPet selectPetNameById(@Param("id") Integer id);

    /**
     *通过用户id查询用户信息
     * @param id
     * @return
     */
     User selectInfoById(@Param("id")Integer id);

    /**
     * 完善用户信息
     * @param user
     */
     void addInfo(User user);

    /**
     * 检查账号是否存在(√)
     * 登陆是用手机号码，也就是检测手机号是否已经被注册
     * @param count 手机号
     * @return true,表示账号存在，false,表示账号不存在
     */
     boolean checkCountExit(@Param("phone") String count);

    /**
     * 学生参加某个活动(√)
     * @param id 活动id
     * @param studentCount 学生账号
     */
     void participateAct(Integer id,Integer studentCount);

    /**
     *得到头像
     * @param id
     * @return 返回头像所存储的照片
     */
     String getHeadPortrait(@Param("id") Integer id);

    /**
     * 添加用户图片
     * @param pic 图片所对应的base64编码
     * @param id
     */
     void addHeadPortrait(@Param("baseCode")String pic,@Param("id") Integer id);

    /**
     * 对用户个数进行统计
     * @return 返回用户的数量
     */
     Integer countAllUser();

    /**
     * 发布学生个人活动
     * @param activity
     */
    void addUserActivity(ActivityUser activity);

    /**
     *获得活动的类型，0为体育活动，1为学术活动，2为志愿活动
     * @param id
     * @return
     */
    Integer getLevelByID(@Param("id") Integer id);
}
