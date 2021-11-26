package controller;

import common.utils.JsonUtil;
import common.utils.Md5Util;
import common.utils.ObjectUtil;
import common.utils.WebUtil;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.OrganizerService;
import service.UserService;
import service.impl.OrganizerServiceImpl;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @author WEIR
 * @description 用户登录注册
 * @date 8/10/2021 - 15:22
 */
@WebServlet("/UserSignServlet")
public class UserSignController extends BaseController {

    public static final String NOW_USER = "nowUser";
    public static final String DATE = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    private static final UserService userService = new UserServiceImpl();
    public static final OrganizerService orgService=new OrganizerServiceImpl();

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String token = WebUtil.getCode(request);
        ResultState result = new ResultState();
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        System.out.println("验证码为："+token);
        // 删除 Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String vcode = request.getParameter("vcode");
//        System.out.println(vcode);
//        System.out.println("登录" + DATE);
        User user = null;
        //判断验证码
//        if (token != null && token.equalsIgnoreCase(vcode)) {
            //登录
            if (userService.checkUserCount(phone)) {
                try {
                    user = userService.login(phone, Md5Util.getMd5String(password));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user == null) {
                    result.setMsg("用户名错误或密码错误！");
                } else {
                    result.setMsg("登陆成功!");
                    result.setCode(true);
                    //存入当前登录的用户
                    request.getSession().setAttribute("nowUser", user);
//                    System.out.println("登陆成功！");
                    System.out.println(request.getSession().getAttribute("nowUser").toString());
                }
            } else if(orgService.checkOrgPhone(phone)!=null) {
                //组织登录
                System.out.println("组织登录");
                try {
                    request.getRequestDispatcher("/Organizer").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }else {
                result.setMsg("用户名不存在！");
            }
//        } else {
//            result.setMsg("验证码错误!");
//        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Session中的验证码
        ResultState result = new ResultState();
        String token = WebUtil.getCode(request);
        String vcode = request.getParameter("vcode");
        String phone = request.getParameter("phone");
        Integer count = Integer.valueOf(request.getParameter("count"));
        String password = request.getParameter("password");
//        System.out.println("注册" + DATE);
        //检查 验证码是否正确
//        if (token != null && token.equalsIgnoreCase(vcode)) {
            //判断用户名是否存在
            if (!userService.checkUserCount(phone)) {
                //判断用户是否已存在
                //调用ObjectUtil工具类获取实例
                try {
                    userService.register(new User(count,Md5Util.getMd5String(password),phone));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result.setMsg("注册成功！");
                result.setCode(true);
            } else {
                result.setMsg("该用户已存在！");
            }
//        } else {
//            result.setMsg("验证码错误!");
//        }
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

}
