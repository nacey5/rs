package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import common.utils.WebUtil;
import pojo.bean.Organizer;
import pojo.dto.ResultState;
import service.OrganizerService;
import service.impl.OrganizerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 27/10/2021 - 15:22
 */
@WebServlet("/Organizer")
public class OrganizerSignController extends BaseController {
    public static final String NOW_ORG = "nowOrg";
    private static OrganizerService organizerService = new OrganizerServiceImpl();

    /**
     * 社团组织登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        String vcode = request.getParameter("vcode");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Organizer org = null;
        try {
            org = organizerService.orgLogin(phone, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (org == null) {
            result.setMsg("组织名称错误或密码错误！");
        } else {
            result.setMsg("登陆成功!");
            result.setCode(true);
            //存入当前登录的组织
            request.getSession().setAttribute(NOW_ORG, org);
        }
        //调用工具类返回结果
        System.out.println(result);
        JsonUtil.returnJson(response, result);
    }

    /**
     * 社团组织注册
     *
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        String token = WebUtil.getCode(request);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String vcode = request.getParameter("vcode");
        //调用ObjectUtil工具类获取实例
        Organizer org = (Organizer) ObjectUtil.getObject(request, Organizer.class);
        //检查 验证码是否正确
        if (token != null && token.equalsIgnoreCase(vcode)) {
            //判断组织名是否存在
            if (!organizerService.checkOrgName(phone)) {
                //判断该组织是否已存在
                //调用ObjectUtil工具类获取实例
                try {
                    organizerService.orgRegister((Organizer) ObjectUtil.getObject(request, Organizer.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result.setMsg("注册成功！");
                result.setCode(true);
            } else {
                result.setMsg("该组织已存在！");
            }
        } else {
            result.setMsg("验证码错误!");
        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }
}
