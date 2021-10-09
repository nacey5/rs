package dao;

import pojo.bean.User;
import pojo.bean.UserPet;
import org.apache.ibatis.annotations.Param;

/**
 * @author DAHUANG
 * @description
 * @date 8/10/2021 - 15:37
 */
public interface UserDao {

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
     * 通过id添加昵称
     * @param id
     * @param petName
     */
     void addPetName(@Param("id") int id,@Param("petName") String petName);

    /**
     * 通过id查找昵称
     * @param id
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
     * 检查账号是否存在
     * @param count
     */
     void checkCountExit(String count);

    /**
     * 学生参加某个活动
     * @param id 活动id
     * @param studentCount 学生账号
     */
     void participateAct(Integer id,Integer studentCount);

}
