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
}
