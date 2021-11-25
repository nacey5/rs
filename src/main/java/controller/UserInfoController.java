package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import pojo.bean.PactInfo;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:16
 */
@WebServlet("/UserInfo")
public class UserInfoController extends BaseController {

    private UserService userService;
    private final ResultState result = new ResultState();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
        //获取当前用户的id
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        Integer id = nowUser.getId();
        id=11;
        //调用ObjectUtil工具类获取实例
        User newUser = (User) ObjectUtil.getObject(request, User.class);
        newUser.setId(id);
        System.out.println(newUser);
        result.setCode(true);
        result.setMsg("修改信息成功！");
        try {
            userService.updateUser(newUser);
        } catch (Exception e) {
            result.setCode(false);
            result.setMsg("修改信息失败！");
        }
        JsonUtil.returnJson(response, result);
    }
}
