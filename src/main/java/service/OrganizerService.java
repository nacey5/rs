package service;

import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:31
 */
public interface OrganizerService {
    /**
     * 通过手机号码和密码查询组织
     *
     * @param phone
     * @param password
     * @return
     */
    Organizer selectInfoByPhoneAndPassword(String phone, String password);

    /**
     * 注册
     *
     * @param org
     */
    void orgRegister(Organizer org);


    /**
     * 查询头像
     *
     * @param id
     * @return 返回头像所存储的照片对应的base64编码
     */
    String selectHeadPortrait(Integer id);

    /**
     * 添加组织社团的介绍信息
     *
     * @param id
     * @param info
     */
    void addInfo(Integer id, String info);

    /**
     * 查找信息
     *
     * @param id
     * @return
     */
    String selectInfo(Integer id);

    /**
     * 一次性查询几个（具体看设计图）社团组织(用于展示在社团组织页面)
     *
     * @param start
     * @param end
     * @return 社团组织对象数组
     */
    List<Organizer> getOrgs(int start, int end);

    /**
     * 检查组织是否存在
     *
     * @param count
     * @return
     */
    boolean checkOrgName(Integer count);
    /**
     * 根据组织名称查询组织对象-----(模糊查询)
     * @param name 组织名
     * @return 返回名称中含有name的组织
     */
    List<Organizer> queryOrgsByName(String name);
}

