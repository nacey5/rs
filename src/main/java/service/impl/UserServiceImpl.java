package service.impl;

import common.factory.DaoFactory;
import dao.UserDao;
import pojo.bean.User;
import service.UserService;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 21:03
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = (UserDao) DaoFactory.getDao(User.class);

    @Override
    public Boolean checkUserName(Integer count) {
        try {
            return userDao.checkCountExit(String.valueOf(count));
        } catch (Exception e) {
            throw new RuntimeException("检验用户名失败！");
        }
    }

    @Override
    public User login(String phone, String password) {
        try {
            return userDao.selectInfoByPhone(phone, password);
        } catch (Exception e) {
            throw new RuntimeException("登录失败！");
        }
    }

    @Override
    public void register(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException("注册失败!");
        }
    }

    @Override
    public User queryUserInfo(Integer id) {
        try {
            return userDao.selectInfoById(id);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败!");
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userDao.addInfo(user);
        } catch (Exception e) {
            throw new RuntimeException("完善资料失败！");
        }
    }

    @Override
    public void addUserImg(Integer id, String imgStr) {

    }
}
