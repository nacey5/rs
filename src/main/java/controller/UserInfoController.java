package controller;

import common.utils.ObjectUtil;
import common.utils.WebUtil;
import org.apache.commons.beanutils.BeanUtils;
import pojo.bean.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:16
 */
@WebServlet("/UserInfoServlet")
public class UserInfoController extends BaseController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户信息
     * @param request
     * @param response
     * @return
     */
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            userService.queryUserInfo(WebUtil.parseInt(id, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置用户信息
     * @param request
     * @param response
     * @return
     */
    public void setUserInfo(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        User user= (User) ObjectUtil.getObject(request, User.class);
        userService.updateUser(user);
    }

}
