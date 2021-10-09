package controller;

import common.exception.NullParameterException;
import common.utils.WebUtil;
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
public class UserInfoController extends BaseController{

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String id =request.getParameter("id");
        try {
             userService.queryUserInfo(WebUtil.parseInt(id));
        } catch (NullParameterException e) {
            e.printStackTrace();
        }

    }

}
