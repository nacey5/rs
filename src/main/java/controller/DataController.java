package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.dto.ResultState;
import service.ActivityService;
import service.OrganizerService;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.OrganizerServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 5/11/2021 - 17:13
 */
@WebServlet("/Data")
public class DataController extends BaseController{

    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    public static final OrganizerService organizationService=new OrganizerServiceImpl();
    /**
     *
     * @param request
     * @param response
     */
    public void setClickClub(HttpServletRequest request, HttpServletResponse response){
        ResultState result = new ResultState();
        String clickClubUrl=request.getParameter("clickClub");
        request.getSession().setAttribute("clickClub",clickClubUrl);
        result.setCode(true);
        JsonUtil.returnJson(response,result);
    }

    /**
     *
     * @param request
     * @param response
     */
    public void setClickMatch(HttpServletRequest request, HttpServletResponse response){
        ResultState result = new ResultState();
        String clickMatchUrl=request.getParameter("clickMatch");
        request.getSession().setAttribute("clickMatch",clickMatchUrl);
        result.setCode(true);
        JsonUtil.returnJson(response,result);
    }

    /**
     *
     * @param request
     * @param response
     */
    public void setNowAct(HttpServletRequest request, HttpServletResponse response){
        ResultState result = new ResultState();
        String nowActName=request.getParameter("nowActName");
        ActivityUser nowAct = activityService.getActivityByName(nowActName);
        request.getSession().setAttribute("nowAct",nowAct);
        result.setCode(true);
        JsonUtil.returnJson(response,result);
    }

}
