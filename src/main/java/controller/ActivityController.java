package controller;

import common.utils.ObjectUtil;
import common.utils.WebUtil;
import pojo.bean.ActivityUser;
import service.ActivityService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description
 * @date 13/10/2021 - 19:02
 */
@WebServlet("/ActivityServlet")
public class ActivityController extends BaseController {

    private static ActivityService activityService;


    public static ActivityService getActivityService() {
        return activityService;
    }

    public void addActivity(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        ActivityUser addActivity = (ActivityUser) ObjectUtil.getObject(request, ActivityUser.class);
        activityService.addActivity(addActivity);
    }

    public void deleteActivity(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        activityService.deleteActivityById(WebUtil.parseInt(id, -1));
    }

    public void updateActivity(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        ActivityUser updateActivity = (ActivityUser) ObjectUtil.getObject(request, ActivityUser.class);
        if (updateActivity != null) {
            activityService.updateActivityById(updateActivity.getId(), updateActivity);
        }
    }

    public static void setActivityService(ActivityService activityService) {
        ActivityController.activityService = activityService;
    }
}
