package dao;

import org.apache.ibatis.annotations.Param;
import pojo.bean.Organizer;
import pojo.bean.User;

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
}
