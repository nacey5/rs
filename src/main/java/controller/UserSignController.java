package controller;

import common.exception.NullParameterException;
import common.utils.JsonUtil;
import common.utils.Md5Util;
import common.utils.WebUtil;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description 用户登录注册
 * @date 8/10/2021 - 15:22
 */
@WebServlet("/UserSignServlet")
public class UserSignController extends BaseController {

    private static  UserService userService;
    /**
     *
     */
    private ResultState state=new ResultState();

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("pwd");
        //登录
//        User user = userService.login(phone, Md5Util.getMd5String(password));
//        if (user == null) {
//            state.setMsg("用户不存在！");
//            state.setCode(false);
//        } else {
//            state.setCode(true);
//            state.setMsg("登陆成功!");
//        }
        state.setCode(true);
        state.setMsg(userName+password);
        //调用工具类返回结果
        JsonUtil.returnJson(response, state);
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String phone = request.getParameter("phone");
        String password = request.getParameter("pwd");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        int count;
        state.setMsg("注册成功!");
        state.setCode(true);
        try {
            //调用工具类，将string转为int,
            count = WebUtil.parseInt(request.getParameter("count"));
            //注册
            userService.register(new User(userName, count, Md5Util.getMd5String(password), phone, gender));
        } catch (NullParameterException e) {
            //出现空参数异常
            state.setMsg(e.getMessage());
            state.setCode(false);
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, state);
    }

//------------------转到SqlUtil------------------
//    public static SqlSessionFactory getSqlSessionFactory() {
//        String resource = "conf/mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new SqlSessionFactoryBuilder().build(inputStream);
//    }

    //----------转到UserServiceImpl-------------------
//    /**
//     *
//     * 用户登陆
//     */
//
//    public void test01(){
//        String phone;
//        String password;
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//        try {
//            UserDao mapper = openSession.getMapper(UserDao.class);
//            User user = mapper.selectInfoByPhone("1008611", "123456");
//            //用户查找不到，需要注册
//            if (user==null){
//                System.out.println("用户找不到");
//            }
//            //用户找到了，进入页面
//            else {
//                System.out.println(user);
//            }
//        }finally {
//            openSession.close();
//        }
//    }
//    /**
//     * 用户注册
//     */
//    public void test02(){
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//
//        try {
//            UserDao mapper = openSession.getMapper(UserDao.class);
//            User user=new User("小蓝",201543201,"大数据与信息分析",null,"a1160124552","1008610",null,null);
//            mapper.addUser(user);
//            System.out.println("注册成功");
//            openSession.commit();
//        }catch (Exception e){
//            throw new RuntimeException("注册失败");
//        }finally {
//            openSession.close();
//        }
//    }
//    /**
//     * 增加昵称
//     */
//    public void test03(){
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//
//        try {
//            UserDao mapper = openSession.getMapper(UserDao.class);
//            mapper.addPetName(7, "小狗汪汪");
//            System.out.println("添加成功");
//            openSession.commit();
//        }catch (Exception e){
//            throw  new RuntimeException("添加昵称失败");
//        }finally {
//            openSession.close();
//        }
//    }
//    /**
//     * 查询用户的所有信息
//     */
//    public void test04(){
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//
//        try {
//            UserDao mapper = openSession.getMapper(UserDao.class);
//            User user = mapper.selectInfoById(1);
//            System.out.println(user);
//        }finally {
//            openSession.close();
//        }
//    }

}
