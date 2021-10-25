package dao;

import org.apache.ibatis.annotations.Param;
import pojo.bean.Organizer;
import pojo.bean.User;

/**
 * @author DAHUANG
 */
public interface OrganizatorDao {
    /**
     * 通过手机号码和密码查询组织
     * @param phone
     * @param password
     * @return
     */
    Organizer selectInfoByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    /**
     * 添加组织用户
     * @param org
     */
    void addOrg(Organizer org);

    /**
     *得到头像
     * @param id
     * @return 返回头像所存储的照片对应的base64编码
     */
    String getHeadPortrait(@Param("id") Integer id);
}
