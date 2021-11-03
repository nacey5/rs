package controller;

import common.utils.JsonUtil;
import pojo.bean.Organizer;
import pojo.bean.User;
import pojo.dto.ResultState;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author WEIR
 * @description
 * @date 3/11/2021 - 22:39
 */
@WebServlet("/Find")
public class FindOrgAndUserController {

    private ResultState result = new ResultState();

    /**
     * 首页查询是否有个人或者组织登录
     *
     * @param request
     * @param response
     */
    public void findUserOrOrg(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User nowUser= (User) session.getAttribute(UserSignController.NOW_USER);
        Organizer nowOrg= (Organizer)session.getAttribute(OrganizerSignController.NOW_ORG);
        if (nowUser!=null){
            //个人登录
            result.setCode(true);
            result.getDatas().put(UserSignController.NOW_USER,nowUser);
        }else if(nowOrg!=null){
            //组织登录
            result.setCode(true);
            result.getDatas().put(UserSignController.NOW_USER,nowOrg);
        }
        //如果两种清空都不是，则无用户登录，可将result直接返回，因为其code默认为false

        JsonUtil.returnJson(response,result);
    }
    /**
     * 查询登录的USer
     *
     * @param request
     * @param response
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 查询登录的组织
     * @param request
     * @param response
     */
    public void findOrg(HttpServletRequest request, HttpServletResponse response) {

    }
}
