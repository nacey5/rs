package service;

import pojo.bean.User;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 15:37
 */
public interface UserService {
    /**
     * 用户登录
     * @param phone
     * @param password
     */
    User login(String phone, String password);

    /**
     * 用户注册
     * @param user
     */
    void register(User user);
    /**
     * 查询用户的所有信息
     * @param id
     * @return
     */
    User queryUserInfo(Integer id);

    /**
     * 完善用户资料
     * @param user
     */
    void updateUser(User user);
}
