package controller;

import com.google.gson.JsonObject;
import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import pojo.bean.ActivityUser;
import pojo.dto.ResultState;
import service.ActivityService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 13/10/2021 - 19:02
 */
@WebServlet("/Activity")
public class ActivityController{

    private static ActivityService activityService;
    private final ResultState result = new ResultState();

    /**
     * 添加活动
     * @param request
     * @param response
     */
    public void addActivity(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        ActivityUser addActivity = (ActivityUser) ObjectUtil.getObject(request, ActivityUser.class);
        activityService.addActivity(addActivity);
    }
    /**
     * 删除活动
     * @param request
     * @param response
     */
    public void deleteActivity(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        activityService.deleteActivityById(Integer.valueOf(id));
    }
    /**
     * 更新活动
     * @param request
     * @param response
     */
    public void updateActivity(HttpServletRequest request, HttpServletResponse response) {
        //调用ObjectUtil工具类获取实例
        ActivityUser updateActivity = (ActivityUser) ObjectUtil.getObject(request, ActivityUser.class);
        if (updateActivity != null) {
            activityService.updateActivityById(updateActivity.getId(), updateActivity);
        }
    }
    /**
     * 获取活动
     * @param request
     * @param response
     */
    public void selectActivity(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ActivityUser activityUser = activityService.selectActivity(Integer.valueOf(id));
        result.getData().put("activityUser",activityUser);
        JsonUtil.returnJson(response,result);
    }

    public void getActList(HttpServletRequest request, HttpServletResponse response){

        List<ActivityUser> actList = activityService.getActivity(-1, 1);
        result.getData().put("actList",actList);
        JsonUtil.returnJson(response,result);
    }



    public static void setActivityService(ActivityService activityService) {
        ActivityController.activityService = activityService;
    }
}
