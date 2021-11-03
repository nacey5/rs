package service;

import pojo.bean.User;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 15:37
 */
public interface UserService {
    /**
     * 检查用户是否存在
     * @param count
     * @return
     */
    Boolean checkUserCount(String count);
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

    /**
     * 添加用户头像
     * @param id
     * @param imgStr
     */
    void addUserImg(Integer id,String imgStr);
    /**
     * 根据用户名查询用户信息
     * @param name 用户名
     * @return 返回null表示没有这个用户，反之亦然
     */
    User queryUserByName(String name);

}
