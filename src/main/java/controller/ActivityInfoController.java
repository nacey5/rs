package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.dto.ResultState;
import service.ActivityService;
import service.impl.ActivityServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WEIR
 * @description 活动信息
 * @date 16/10/2021 - 20:59
 */
@WebServlet("/ActivityInfo")
public class ActivityInfoController  extends BaseController{

    private ActivityService activityService=new ActivityServiceImpl();
    private ResultState result = new ResultState();

    /**
     *设置活动信息
     * @param request
     * @param response
     */
    public void setActivityInfo(HttpServletRequest request, HttpServletResponse response){
        String info=request.getParameter("ActivityInfo");
        activityService.addActivityInfo(Integer.valueOf(request.getParameter ("actId")),info);
    }

    /**
     *获取活动信息
     * @param request
     * @param response
     */
    public void getActivityInfo(HttpServletRequest request, HttpServletResponse response){
        ActivityUser activityUser = activityService.selectActivity(Integer.valueOf(request.getParameter("actId")));
        result.getDatas().put("activityInfo",activityUser.getInfo());
        JsonUtil.returnJson(response,result);
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
