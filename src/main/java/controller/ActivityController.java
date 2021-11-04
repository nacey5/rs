package controller;

import common.utils.JsonUtil;
import common.utils.ObjectUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Pictures;
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
import java.util.HashMap;
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

    /**
     * 发布活动
     *
     * @param request
     * @param response
     */
    public void addActivity(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> upload = (Map<String, Object>) UploadController.upload(request, ActivityUser.class);
        ActivityUser addActivity = new ActivityUser();
        List<String> actList = (List<String>) upload.get("actList");

        addActivity.setName(actList.get(0));
        addActivity.setTime(actList.get(1));
        addActivity.setOrganizer(Integer.valueOf(actList.get(2)));
        addActivity.setAdress(actList.get(3));
        addActivity.setJoinWay(actList.get(4));

        //调用ObjectUtil工具类获取实例
        if (activityService.checkActivityName(addActivity.getName())) {
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
