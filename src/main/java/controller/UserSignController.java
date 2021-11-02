package controller;

import common.utils.JsonUtil;
import common.utils.Md5Util;
import common.utils.ObjectUtil;
import common.utils.WebUtil;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WEIR
 * @description 用户登录注册
 * @date 8/10/2021 - 15:22
 */
@WebServlet("/UserSignServlet")
public class UserSignController extends BaseController {

    public static final String DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    private static UserService userService;
    private final ResultState result = new ResultState();

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String token = WebUtil.getCode(request);
        String userName = request.getParameter("username");
        String password = request.getParameter("psd");
        String vcode = request.getParameter("vcode");
        System.out.println("登录" +DATE);
        //登录
        User user = userService.login(userName, Md5Util.getMd5String(password));
        if (user == null) {
            result.setMsg("用户名错误或密码错误！");
            result.setCode(false);
        } else if ("13456789000".equals(userName) && "123456".equals(password) && token != null && token.equalsIgnoreCase(vcode)) {
            result.setCode(true);
            result.setMsg("登陆成功!");
        } else if (token == null || !token.equalsIgnoreCase(vcode)) {
            result.setMsg("验证码错误!");
        }
        //存入当前登录的用户
        request.getSession().setAttribute("nowUser", user);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = WebUtil.getCode(request);
        String vcode = request.getParameter("vcode");
        System.out.println("注册"+DATE);
        if (!token.equalsIgnoreCase(vcode)) {
            result.setMsg("验证码错误!");
        } else if (userService.checkUserCount(Integer.valueOf(request.getParameter("count")))) {
            //判断用户是否已存在
            //调用ObjectUtil工具类获取实例
            userService.register((User) ObjectUtil.getObject(request, User.class));
            result.setMsg("注册成功！");
            result.setCode(true);
        } else {
            result.setMsg("该用户已存在！");
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    public static void setUserService(UserService userService) {
        UserSignController.userService = userService;
    }
}
