package service.impl;

import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.bean.User;
import service.UserService;

import static common.utils.SqlUtil.getSqlSessionFactory;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 21:03
 */
public class UserServiceImpl implements UserService {

    private final SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    private final SqlSession openSession = sqlSessionFactory.openSession();
    private final UserDao mapper = openSession.getMapper(UserDao.class);

    @Override
    public User login(String phone, String password) {
        try {
            return mapper.selectInfoByPhone(phone,password);
        } finally {
            openSession.close();
        }
    }

    @Override
    public void register(User user) {
        try {
            mapper.addUser(user);
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("注册失败!");
        } finally {
            openSession.close();
        }
    }

    @Override
    public User queryUserInfo(Integer id) {
        try {
            return mapper.selectInfoById(id);
        } finally {
            openSession.close();
        }
    }

    /**
     * 完善资料
     */
    @Override
    public void updateUser(User user){
        try {
            mapper.addInfo(user);
//            System.out.println("完善资料成功");
            openSession.commit();
        }catch (Exception e){
            throw  new RuntimeException("完善资料失败");
        }finally {
            openSession.close();
        }
    }
}
