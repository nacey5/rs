package controller;

import common.utils.JsonUtil;
import common.utils.Md5Util;
import common.utils.ObjectUtil;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:16
 */
@WebServlet("/UserInfo")
public class UserInfoController extends BaseController {

    private static UserService userService=new UserServiceImpl();
    private final ResultState result = new ResultState();


    /**
     * 获取用户信息
     *
     * @param request
     * @param response
     * @return
     */
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        User user = new User();
        try {
            user = userService.queryUserInfo(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.getDatas().put("user", user);
        JsonUtil.returnJson(response, result);
    }

    /**
     * 修改用户信息
     *
     * @param request
     * @param response
     * @return
     */
    public void setUserInfo(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        User newUser=null;
        //获取当前用户的id
        try {
            User nowUser = (User) request.getSession().getAttribute("nowUser");
            Integer id = nowUser.getId();
            //调用ObjectUtil工具类获取实例
            newUser = (User) ObjectUtil.getObject(request, User.class);
            newUser.setId(id);
            result.setCode(true);
            result.setMsg("修改信息成功！");
            userService.updateUser(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(false);
            result.setMsg("修改信息失败！");
        }
        //修改成功，更新当前在线用户的信息
        if(result.isCode()){
            String md5Pwd= Md5Util.getMd5String(newUser.getPassword());
            newUser.setPassword(md5Pwd);
            request.getSession().setAttribute("nowUser",newUser);
        }
        JsonUtil.returnJson(response, result);
    }
}
