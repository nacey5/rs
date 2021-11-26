package controller;

import common.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.bean.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 3/11/2021 - 22:39
 */
@WebServlet("/Find")
public class PageInfoController extends BaseController {

    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final OrganizerService organizerService = new OrganizerServiceImpl();

    /**
     * 首页查询是否有个人或者组织登录
     *
     * @param request
     * @param response
     */
    public void findUserOrOrg(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        Organizer nowOrg = (Organizer) request.getSession().getAttribute("nowOrg");
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
        try {
            User nowUser = (User) request.getSession().getAttribute("nowUser");
            result.getDatas().put("nowUser", nowUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String picture = null;
        try {
            ActivityUser nowAct = activityService.selectActByMainPic(url);
            if (nowAct == null) {

            } else {
                String info = activityService.getInfoById(nowAct.getId());
                picture = activityService.getActMainPic(nowAct.getId()).getPicture();
                nowAct.setInfo(info);
            }
            request.getSession().setAttribute("nowAct", nowAct);
            result.getDatas().put("nowAct", nowAct);
            result.getDatas().put("nowActPic", picture);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        List<ActivityUser> actList = new ArrayList<>();
        try {
            actList = userService.selectActListByUserId(nowUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (actList.size() != 0) {
            for (ActivityUser activityUser : actList) {
                //获取对应的图片数组，获取info
                try {

//                    picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
                    String pic = activityService.getActMainPic(activityUser.getId()).getPicture();
                    String defaultHead = "http://localhost:8080/FindMore/image/user.png";
                    String picture=(pic == null ? defaultHead : pic);
                    picList.add(picture);
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
            result.getDatas().put("picList", picList);
            result.getDatas().put("actList", actList);
            result.setCode(true);
        }
        JsonUtil.returnJson(response, result);
    }

    /**
     * 查询赛事活动的参赛者
     *
     * @param request
     * @param response
     */
    public void findParticipaters(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        ActivityUser nowAct = (ActivityUser) request.getSession().getAttribute("nowAct");
        List<String> picList = new ArrayList<>();
        List<Participater> parList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        try {
            parList = activityService.selectStudentsByArtId(nowAct.getId());
        } catch (Exception e) {
//            logger.error(e.getMessage());
        }
        if (parList.size() != 0) {
            for (Participater participater : parList) {
                //获取对应的图片数组，获取info
                try {
                    //通过 userId查询用户信息
                    userList = activityService.selectParByActId(nowAct.getId());
                    String pic = activityService.getActMainPic(participater.getId()).getPicture();
                    String defaultHead = "http://localhost:8080/FindMore/image/user.png";
                    String picture=(pic == null ? defaultHead : pic);
                    picList.add(picture);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            result.getDatas().put("picList", picList);
            result.getDatas().put("userList", userList);
            result.getDatas().put("parList", parList);
            result.setCode(true);
        }
        JsonUtil.returnJson(response, result);
    }

    public void findTime(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        int hours = new Date().getHours();
        result.getDatas().put("hours", hours);
        result.setCode(true);
        JsonUtil.returnJson(response, result);
    }
}
