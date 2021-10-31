package dao;

import org.apache.ibatis.annotations.Param;
import pojo.bean.Organizer;
import pojo.bean.User;

import java.util.List;

public interface OragnizatorDao{
    /**
     * 通过手机号码和密码查询用户
     * @param phone
     * @param password
     * @return
     */
    Organizer selectInfoByPhoneandPassword(@Param("phone") String phone, @Param("password") String password);

    /**
     * 添加组织用户
     * @param org
     */
    void addOrg(Organizer org);

    /**
     *得到头像
     * @param id
     * @return 返回头像所存储的照片
     */
    String getHeadPortrait(@Param("id") Integer id);


    /*=================================================================================================*/
    /**
     * 添加组织社团的介绍信息
     * @param id
     * @param info
     */
    void addInfo(@Param("id") Integer id,@Param("info") String info);

    /**
     * 查找信息
     * @param id
     * @return
     */
    String selectInfo(@Param("id")Integer id);

    /**
     * 查询几条数据
     * @param number1 从num+1条数据开始
     * @param number2 查询多少行
     * @return
     */
    List<Organizer> getOrgs(@Param("num1") Integer number1,@Param("num2") Integer number2);
}
