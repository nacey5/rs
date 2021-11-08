package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import pojo.bean.ActivityUser;
import pojo.bean.User;
import pojo.dto.ResultState;
import service.ActivityService;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 13/10/2021 - 19:02
 */
@WebServlet("/Activity")
public class ActivityController extends BaseController {

    private static ActivityService activityService = new ActivityServiceImpl();
    private static UserService userService = new UserServiceImpl();
    private final ResultState result = new ResultState();
    public static String actInfo;
    public static ActivityUser newAct;

    /**
     * 发布活动
     *
     * @param request
     * @param response
     */
    public void addActivity(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String organizer = request.getParameter("organizer");
        String adress = request.getParameter("adress");
        String joinWay = request.getParameter("joinWay");
        String info = request.getParameter("info");
        String levelText = request.getParameter("level");
        actInfo = info;
        Integer level = 0;
        if (levelText.equals("体育赛事")) {
            level = 0;
        } else if (levelText.equals("学术活动")) {
            level = 1;
        } else if (levelText.equals("志愿活动")) {
            level = 2;
        }
        System.out.println(organizer);
        System.out.println(name);
        ActivityUser addActivity = null;
        try {
            addActivity = new ActivityUser(name, Integer.valueOf(organizer), time, adress, joinWay, level);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(addActivity.toString());
        //调用ObjectUtil工具类获取实例
        if (!activityService.checkActivityName(name)) {
            try {
                activityService.addActivity(addActivity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setMsg("添加活动成功！");
            result.setCode(true);
            //存入session
            request.getSession().setAttribute("newAct", addActivity);
        } else {
            result.setMsg("添加活动失败！该活动已存在！");
        }
        JsonUtil.returnJson(response, result);
    }

    /**
     * 删除活动
     *
     * @param request
     * @param response
     */
    public void deleteActivity(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        activityService.deleteActivityById(Integer.valueOf(id));
    }

    /**
     * 更新活动
     *
     * @param request
     * @param response
     */
    public void updateActivity(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        ActivityUser updateActivity = (ActivityUser) ObjectUtil.getObject(request, ActivityUser.class);
        if (updateActivity != null && activityService.checkActivityName(updateActivity.getName())) {
            try {
                activityService.updateActivityById(updateActivity.getId(), updateActivity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setCode(true);
            result.setMsg("更新用户信息成功");
        } else {
            result.setMsg("更新活动信息失败!");
        }
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取单个活动
     *
     * @param request
     * @param response
     */
    public void selectActivity(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ActivityUser activityUser = activityService.selectActivity(Integer.valueOf(id));
        result.getDatas().put("activityUser", activityUser);
        JsonUtil.returnJson(response, result);
    }

    /**
     * @param request
     * @param response
     */
    public void getActList(HttpServletRequest request, HttpServletResponse response) {

        List<ActivityUser> actList = activityService.getActivity(-1, 1);
        result.getDatas().put("actList", actList);

        JsonUtil.returnJson(response, result);
    }

    /**
     * @param request
     * @param response
     */
    public void getUserActList(HttpServletRequest request, HttpServletResponse response) {
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        List<ActivityUser> actList = userService.selectActListByUserId(nowUser.getId());
        List<String> picList = new ArrayList<>();
        for (ActivityUser activityUser : actList) {
            picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
        }
        result.getDatas().put("actList", actList);
        result.getDatas().put("actPicList", picList);

        JsonUtil.returnJson(response, result);
    }

}
