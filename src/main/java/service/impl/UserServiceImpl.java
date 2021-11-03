package service.impl;

import common.utils.SqlUtil;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import pojo.bean.User;
import service.UserService;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 21:03
 */
public class UserServiceImpl implements UserService {

    private final SqlSession openSession = SqlUtil.getOpeningSession();
    private final UserDao userDao = openSession.getMapper(UserDao.class);

    @Override
    public Boolean checkUserCount(String count) {
        try {
            return userDao.checkCountExit(count);
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
        user.setId(userDao.countAllUser());
        //设置用户默认名称
        user.setUsername(User.BASE_NAME+user.getId());
        try {
            userDao.addUser(user);
            openSession.commit();
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
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("完善资料失败！");
        }
    }

    @Override
    public void addUserImg(Integer id, String pic) {
        try {
            userDao.addHeadPortrait(pic,id);
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加头像失败！");
        }
    }

    @Override
    public User queryUserByName(String name) {
        return null;
    }

}
