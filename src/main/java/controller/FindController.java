package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.bean.Pictures;
import pojo.bean.User;
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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 3/11/2021 - 22:39
 */
@WebServlet("/Find")
public class FindController extends BaseController{

    private static ActivityService activityService=new ActivityServiceImpl();
    private static UserService userService=new UserServiceImpl();
    private static OrganizerService organizerService=new OrganizerServiceImpl();
    private ResultState result = new ResultState();

    /**
     * 首页查询是否有个人或者组织登录
     *
     * @param request
     * @param response
     */
    public void findUserOrOrg(HttpServletRequest request, HttpServletResponse response) {
        User nowUser= (User) request.getSession().getAttribute("nowUser");
        Organizer nowOrg= (Organizer)request.getSession().getAttribute(OrganizerSignController.NOW_ORG);
        System.out.println("now——>"+nowUser);
        if (nowUser!=null){
            //个人登录
            result.setCode(true);
            result.getDatas().put("nowUser",nowUser);
        }else if(nowOrg!=null){
            //组织登录
            result.setCode(true);
            result.getDatas().put("nowOrg",nowOrg);
        }
        //如果两种清空都不是，则无用户登录，可将result直接返回，因为其code默认为false
        JsonUtil.returnJson(response,result);
        System.out.println(result.toString());
    }
    /**
     * 查询登录的USer
     *
     * @param request
     * @param response
     */
    public void findNowUser(HttpServletRequest request, HttpServletResponse response) {
        Object nowUser= request.getSession().getAttribute("nowUser");
        result.getDatas().put("nowOrg",nowUser);
        JsonUtil.returnJson(response,nowUser);
    }

    /**
     * 查询登录的组织
     * @param request
     * @param response
     */
    public void findNowOrg(HttpServletRequest request, HttpServletResponse response) {
        Object nowOrg = request.getSession().getAttribute("nowOrg");
        result.getDatas().put("nowOrg",nowOrg);
        JsonUtil.returnJson(response,nowOrg);
    }
    /**
     * 查询点击的赛事活动
     * @param request
     * @param response
     */
    public void findNowAct(HttpServletRequest request, HttpServletResponse response) {

        String url=request.getParameter("nowActUrl");
        ActivityUser nowAct = activityService.selectActByMainPic(url);
        result.getDatas().put("nowAct",nowAct);
        JsonUtil.returnJson(response,result);
    }
    /**
     * 查询当前用户的赛事
     * @param request
     * @param response
     */
    public void findMyAct(HttpServletRequest request, HttpServletResponse response) {

        User nowUser = (User) request.getSession().getAttribute("nowUser");
        List<String>picList = new ArrayList<>();
        List<ActivityUser> actList = userService.selectActListByUserId(nowUser.getId());
        for (ActivityUser activityUser : actList) {
            //获取对应的图片数组，获取info
            picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
        }
        result.getDatas().put("picList", picList);
        result.getDatas().put("actList",actList);
        JsonUtil.returnJson(response,result);
    }


}
