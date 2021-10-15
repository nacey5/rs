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
    private ResultState state = new ResultState();

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //登录
        User user = userService.login(userName, Md5Util.getMd5String(password));
        if (user == null) {
            state.setMsg("用户不存在！");
            state.setCode(false);
        } else {
            state.setCode(true);
            state.setMsg("登陆成功!");
        }
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
        //判断用户是否已存在
        if (userService.checkUserName(Integer.valueOf(request.getParameter("count")))) {
            //注册
            //调用ObjectUtil工具类获取实例
            userService.register((User) ObjectUtil.getObject(request, User.class));
            state.setMsg("注册成功!");
            state.setCode(true);
        } else {
            state.setMsg("注册失败!该用户已存在！");
            state.setCode(false);
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, state);
    }

    public static void setUserService(UserService userService) {
        UserSignController.userService = userService;
    }

}
