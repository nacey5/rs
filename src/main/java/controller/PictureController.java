package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Pictures;
import pojo.dto.ResultState;
import service.ActivityService;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 16:51
 */
@WebServlet("/Picture")
public class PictureController extends BaseController {

    private static UserService userService;
    private static ActivityService activityService;

    private  ResultState result = new ResultState();

    /**
     * 获取指定赛事的图片
     *
     * @param request
     * @param response
     */
    public void getMatchPic(HttpServletRequest request, HttpServletResponse response) {

        int id = (int)request.getSession().getAttribute("id");
        //获取查询到的图片
        List<Pictures> picList = activityService.getPicture(id);
        //往结果里面存图片数组
        result.getData().put("picList", picList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }
    /**
     * 获取轮播图中赛事的图片
     *
     * @param request
     * @param response
     */
    public  void getMatchPicList(HttpServletRequest request, HttpServletResponse response) {
        List<Pictures> picList = null;
        //往结果里面存图片数组
        result.getData().put("picList", picList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

}
