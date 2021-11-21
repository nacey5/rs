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
        if (nowUser != null) {
            //个人登录
            result.setCode(true);
            result.getDatas().put("nowUser", nowUser);
        } else if (nowOrg != null) {
            //组织登录
            result.setCode(true);
            result.getDatas().put("nowOrg", nowOrg);
        }
        //如果两种情况都不是，则无用户登录，可将result直接返回，因为其code默认为false
        JsonUtil.returnJson(response, result);
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
        ActivityUser nowAct = activityService.selectActByMainPic(url);
        String info = activityService.getInfoById(nowAct.getId());
        String picture = activityService.getActMainPic(nowAct.getId()).getPicture();
        nowAct.setInfo(info);
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
        List<String> picList = new ArrayList<>();
        List<ActivityUser> actList = null;
        try {
            actList = userService.selectActListByUserId(1);
            System.out.println(actList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (actList.size() != 0) {
            for (ActivityUser activityUser : actList) {
                //获取对应的图片数组，获取info
                try {
                    picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            result.getDatas().put("picList", picList);
            result.getDatas().put("actList", actList);
            result.setCode(true);
        }
        JsonUtil.returnJson(response, result);
    }
}
