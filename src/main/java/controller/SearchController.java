package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.dto.ResultState;
import service.ActivityService;
import service.OrganizerService;
import service.impl.ActivityServiceImpl;
import service.impl.OrganizerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 2/11/2021 - 01:00
 */
@WebServlet("/Search")
public class SearchController extends BaseController{

    private ResultState result=new ResultState();
    /**
     * 搜索
     *
     * @param request  请求
     * @param response 响应
     */
    public void search(HttpServletRequest request, HttpServletResponse response) {
        String searchType;
        ActivityService activityService = new ActivityServiceImpl();
        OrganizerService organizerService=new OrganizerServiceImpl();
        //获取搜索的内容
        String searchText = request.getParameter("searchText");
        //搜索内容是否是某个组织
        boolean searchOrgFlag =activityService.checkActivityName(searchText) ;
        if (searchOrgFlag) {
            //搜索组织
            //查询对应的社团组织
            List<Organizer> orgList=organizerService.queryOrgsByName(searchText);
            result.getDatas().put("orgList",orgList);
        } else {
            //搜索赛事活动标题
            //查询对应的赛事活动
            List<ActivityUser> actList = activityService.searchActivityByName(searchText);
            result.getDatas().put("actList",actList);
        }
        //使用json工具类返回结果
        JsonUtil.returnJson(response, result);
    }
}
