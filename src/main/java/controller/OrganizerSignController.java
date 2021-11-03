package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import common.utils.WebUtil;
import pojo.bean.Organizer;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.OrganizerService;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 27/10/2021 - 15:22
 */
@WebServlet("/Organizer")
public class OrganizerSignController extends BaseController{

    private static OrganizerService organizerService;
    private ResultState result = new ResultState();

    /**
     * 社团组织登录
     * @param request
     * @param response
     */
    public void orgLogin(HttpServletRequest request, HttpServletResponse response) {
        String token = WebUtil.getCode(request);
        String vcode = request.getParameter("vcode");
        String userName = request.getParameter("username");
        String password = request.getParameter("psd");

        Organizer organizer = organizerService.selectInfoByPhoneAndPassword(userName, password);

        if (!token.equalsIgnoreCase(vcode)) {
            result.setMsg("验证码错误!");
        } else if (organizer == null) {
            result.setMsg("用户名错误或密码错误！");
        } else {
            result.setMsg("登陆成功!");
            result.setCode(true);
        }
        //存入当前登录的用户
        request.getSession().setAttribute("nowOrg", organizer);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 社团组织注册
     * @param request
     * @param response
     */
    public void orgRegister(HttpServletRequest request, HttpServletResponse response) {

        String token = WebUtil.getCode(request);
        String vcode = request.getParameter("vcode");
        //调用ObjectUtil工具类获取实例
        Organizer org = (Organizer) ObjectUtil.getObject(request, Organizer.class);
        //查询组织用户
        Organizer organizer = organizerService.selectInfoByPhoneAndPassword(org.getPhone(), org.getPassword());
        if (!token.equalsIgnoreCase(vcode)) {
            result.setMsg("验证码错误!");
        } else if (organizer == null) {
            //判断用户是否已存在
            organizerService.orgRegister(org);
            result.setMsg("注册成功！");
            result.setCode(true);
        } else {
            result.setMsg("该用户已存在！");
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }
}
