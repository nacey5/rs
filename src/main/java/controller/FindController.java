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
public class FindController extends BaseController {

    private static ActivityService activityService = new ActivityServiceImpl();
    private static UserService userService = new UserServiceImpl();
    private static OrganizerService organizerService = new OrganizerServiceImpl();

    /**
     * 首页查询是否有个人或者组织登录
     *
     * @param request
     * @param response
     */
    public void findUserOrOrg(HttpServletRequest request, HttpServletResponse response) {

        ResultState result = new ResultState();
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        Organizer nowOrg = (Organizer) request.getSession().getAttribute(OrganizerSignController.NOW_ORG);
        System.out.println("now——>" + nowUser);
        if (nowUser != null) {
            //个人登录
            result.setCode(true);
            result.getDatas().put("nowUser", nowUser);
        } else if (nowOrg != null) {
            //组织登录
            result.setCode(true);
            result.getDatas().put("nowOrg", nowOrg);
        }
        //如果两种清空都不是，则无用户登录，可将result直接返回，因为其code默认为false
        JsonUtil.returnJson(response, result);
        System.out.println(result.toString());
    }

    /**
     * 查询登录的USer
     *
     * @param request
     * @param response
     */
    public void findNowUser(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        User nowUser = (User) request.getSession().getAttribute("nowUser");

        System.out.println(nowUser);

        result.getDatas().put("nowUser", nowUser);
        JsonUtil.returnJson(response, result);
    }

    /**
     * 查询登录的组织
     *
     * @param request
     * @param response
     */
    public void findNowOrg(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        String url = (String) request.getSession().getAttribute("clickClub");
        System.out.println(url);
        Organizer nowOrg = null;
        String info = null;
        try {
            nowOrg = organizerService.selectOrgByHeadPortrait(url);
            if (nowOrg != null) {
                info = organizerService.selectInfo(nowOrg.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("nowOrg——>" + nowOrg);
        System.out.println("nowOrgInfo——>" + info);
        result.getDatas().put("nowOrg", nowOrg);
        result.getDatas().put("nowOrgPic", url);
        result.getDatas().put("nowOrgInfo", info);
        JsonUtil.returnJson(response, result);
    }

    /**
     * 查询点击的赛事活动
     *
     * @param request
     * @param response
     */
    public void findNowAct(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();

        String url = (String) request.getSession().getAttribute("clickMatch");
        System.out.println(url);
        ActivityUser nowAct = activityService.selectActByMainPic(url);
        String info = activityService.getInfoById(nowAct.getId());
        String picture = activityService.getActMainPic(nowAct.getId()).getPicture();
        nowAct.setInfo(info);
        System.out.println("nowAct——>" + nowAct);
        result.getDatas().put("nowAct", nowAct);
        result.getDatas().put("nowActPic", picture);
        JsonUtil.returnJson(response, result);
    }

    /**
     * 查询当前用户的赛事
     *
     * @param request
     * @param response
     */
    public void findMyAct(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        System.out.println(nowUser);
        List<String> picList = new ArrayList<>();
        List<ActivityUser> actList = userService.selectActListByUserId(nowUser.getId());
        if (actList.size() != 0) {
            for (ActivityUser activityUser : actList) {
                //获取对应的图片数组，获取info
                picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
            }
            result.getDatas().put("picList", picList);
            result.setCode(true);
            result.getDatas().put("actList", actList);
        }
        JsonUtil.returnJson(response, result);
    }
}
