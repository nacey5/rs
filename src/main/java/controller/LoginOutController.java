package controller;

import com.google.gson.JsonObject;
import common.utils.JsonUtil;
import pojo.dto.ResultState;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author WEIR
 * @description 用户(组织或者学生)注销
 * @date 2/11/2021 - 15:06
 */
@WebServlet("/LoginOut")
public class LoginOutController extends BaseController{

    private ResultState result = new ResultState();

    /**
     * 注销
     *
     * @param request
     * @param response
     */
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {
        //销毁Session）
        request.getSession().invalidate();
        result.setMsg("退出成功");
        result.setCode(true);
        JsonUtil.returnJson(response,result);
    }
}
