package controller;

import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.bean.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WEIR
 * @description 用户登录注册
 * @date 8/10/2021 - 15:22
 */

public class UserSignServlet {

    public UserSignServlet() {
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     *
     * 用户登陆
     */
    @Test
    public void test01(){
        String phone;
        String password;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            UserDao mapper = openSession.getMapper(UserDao.class);
            User user = mapper.SelectInfoByPhone("1008611", "123456");
            //用户查找不到，需要注册
            if (user==null){
                System.out.println("用户找不到");
            }
            //用户找到了，进入页面
            else {
                System.out.println(user);
            }
        }finally {
            openSession.close();
        }
    }

    /**
     * 用户注册
     */
    @Test
    public void test02(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UserDao mapper = openSession.getMapper(UserDao.class);
            User user=new User("小蓝",201543201,"大数据与信息分析",null,"a1160124552","1008610",null,null);
            mapper.addUser(user);
            System.out.println("注册成功");
            openSession.commit();
        }catch (Exception e){
            throw new RuntimeException("注册失败");
        }finally {
            openSession.close();
        }
    }

    /**
     * 增加昵称
     */
    @Test
    public void test03(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UserDao mapper = openSession.getMapper(UserDao.class);
            mapper.addPetName(7, "小狗汪汪");
            System.out.println("添加成功");
            openSession.commit();
        }catch (Exception e){
            throw  new RuntimeException("添加昵称失败");
        }finally {
            openSession.close();
        }
    }

    /**
     * 查询用户的所有信息
     */
    @Test
    public void test04(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UserDao mapper = openSession.getMapper(UserDao.class);
            User user = mapper.SelectInfoById(1);
            System.out.println(user);
        }finally {
            openSession.close();
        }
    }
}
