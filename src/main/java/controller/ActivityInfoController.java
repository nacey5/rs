package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import pojo.bean.ActivityUser;
import pojo.bean.PactInfo;
import pojo.bean.User;
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
public class ActivityInfoController extends BaseController {

    private ActivityService activityService = new ActivityServiceImpl();

    /**
     * 设置活动信息
     *
     * @param request
     * @param response
     */
    public void setActivityInfo(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        String info = request.getParameter("ActivityInfo");
        result.setCode(true);
        result.setMsg("添加活动信息成功！");
        try {
            activityService.addActivityInfo(Integer.valueOf(request.getParameter("actId")), info);
        } catch (Exception e) {
            result.setCode(false);
            result.setMsg("添加活动信息失败！");
        }
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取活动信息
     *
     * @param request
     * @param response
     */
    public void getActivityInfo(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        ActivityUser activityUser = activityService.selectActivity(Integer.valueOf(request.getParameter("actId")));
        result.getDatas().put("activityInfo", activityUser.getInfo());
        JsonUtil.returnJson(response, result);
    }

    /**
     * 报名
     *
     * @param request
     * @param response
     */
    public void enroll(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        //获取当前用户的id
        User nowUser = (User) request.getSession().getAttribute("nowUser");
        Integer id = nowUser.getId();
        result.setCode(true);
        result.setMsg("报名成功！");
        try {
            PactInfo info = (PactInfo) ObjectUtil.getObject(request, PactInfo.class);
            info.setId(id);
            activityService.enroll(info);
        } catch (Exception e) {
            result.setCode(false);
            result.setMsg("报名失败！");
        }
        JsonUtil.returnJson(response, result);
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
