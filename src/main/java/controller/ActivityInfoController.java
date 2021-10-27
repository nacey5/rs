package controller;

import common.utils.Base64Util;
import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Pictures;
import service.ActivityService;
import service.impl.ActivityServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author WEIR
 * @description 活动信息
 * @date 16/10/2021 - 20:59
 */
@WebServlet("/ActivityInfo")
public class ActivityInfoController  extends BaseController{

    private ActivityService activityService=new ActivityServiceImpl();

    public void setActivityInfo(HttpServletRequest request, HttpServletResponse response){
        String info=request.getParameter("ActivityInfo");
        activityService.addActivityInfo(Integer.valueOf(request.getParameter ("actId")),info);

    }
    public void getActivityInfo(HttpServletRequest request, HttpServletResponse response){
        ActivityUser activityUserser = activityService.selectActivity(Integer.valueOf(request.getParameter("actId")));

        JsonUtil.returnJson(response,activityUserser.getInfo());
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
