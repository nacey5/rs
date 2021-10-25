package service;

import common.factory.DaoFactory;
import dao.OrganizatorDao;
import org.apache.ibatis.annotations.Param;
import pojo.bean.Organizer;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:31
 */
public interface OrganizerService {
    /**
     * 通过手机号码和密码查询组织
     * @param phone
     * @param password
     * @return
     */
    Organizer selectInfoByPhoneAndPassword(String phone, String password);

    /**
     * 注册
     * @param org
     */
    void orgRegister(Organizer org);

    /**
     *查询头像
     * @param id
     * @return 返回头像所存储的照片对应的base64编码
     */
    String selectHeadPortrait(Integer id);
}
