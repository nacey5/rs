package controller;

import annotation.WebRequest.RequestMapping;
import common.utils.JsonUtil;
import pojo.dto.ResultState;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author WEIR
 * @description 用户登录注册
 * @date 8/10/2021 - 15:22
 */
@WebServlet("/UserSignServlet")
public class UserSignController extends BaseController {

    private static UserService userService;
    /**
     *
     */
    private ResultState result = new ResultState();

    static String token;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        String action = request.getParameter("action");
//        System.out.println(action);
//        if ("login".equals(action)) {
//            login(request, resp);
//        } else if ("register".equals(action)) {
//            register(request, resp);
//        } else {
//            result.setMsg("xxxxx");
//            JsonUtil.returnJson(resp, result);
//        }
//        // 获取Session中的验证码
//        token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        // 删除 Session中的验证码
//        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
//    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    @RequestMapping(url = "/UserSignServlet")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String vcode = request.getParameter("vcode");
        System.out.println(username);
        System.out.println("登录" + new Date().toString());
        System.out.println(token);
//        //登录
//        User user = userService.login(userName, Md5Util.getMd5String(password));
//        if (user == null) {
//            result.setMsg("用户不存在！");
//            result.setCode(false);
//        } else {
//        if("13456789000".equals(phone)&&"123456".equals(password)&&token!=null&&token.equalsIgnoreCase(vcode)){
//            result.setCode(true);
//            result.setMsg("登陆成功!");
//        }else if(token ==null||!token.equalsIgnoreCase(vcode)){
//            result.setMsg("验证码错误!");
//        }else {
//        }
        result.setMsg("账号或密码错误!");

        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
        System.out.println(request.getMethod());
        System.out.println(result.toString());
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vcode = request.getParameter("vcode");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        System.out.println(phone + "11111");
        System.out.println(password + "2222");
        System.out.println("注册" + new Date().toString());
        //判断用户是否已存在
//        if (userService.checkUserName(Integer.valueOf(request.getParameter("count")))) {
//            //注册
//            //调用ObjectUtil工具类获取实例
//            userService.register((User) ObjectUtil.getObject(request, User.class));
//        } else {
//            result.setMsg("注册失败!该用户已存在！");
//            result.setCode(false);
//        }
        String count = request.getParameter("count");
        if (token != null && token.equalsIgnoreCase(vcode)) {
            result.setMsg("注册成功!");
            result.setCode(true);
        } else {
            result.setMsg("验证码错误!");
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    public static void setUserService(UserService userService) {
        UserSignController.userService = userService;
    }

}
