package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.bean.Pictures;
import pojo.dto.ResultState;
import service.ActivityService;
import service.OrganizerService;
import service.SearchService;
import service.impl.ActivityServiceImpl;
import service.impl.OrganizerServiceImpl;
import service.impl.SearchServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 2/11/2021 - 01:00
 */
@WebServlet("/Search")
public class SearchController extends BaseController {

    public static final ActivityService activityService = new ActivityServiceImpl();
    public static final OrganizerService organizerService = new OrganizerServiceImpl();
    public static final SearchService searchService = new SearchServiceImpl();

    /**
     * 搜索
     *
     * @param request  请求
     * @param response 响应
     */
    public void search(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
//获取搜索的内容
        String text = request.getParameter("searchText");
        System.out.println(text);
        request.getSession().setAttribute("searchText", text);
        result.setCode(true);
        //使用json工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 搜索提示
     *
     * @param request
     * @param response
     */
    public void findSearchTips(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        String searchText = request.getParameter("searchText");
        List<String> strings = searchService.searchByKeyWords(searchText);
        result.setCode(true);
        result.getDatas().put("strings", strings);
        System.out.println(result);
        JsonUtil.returnJson(response, result);
    }

    /**
     * @param request
     * @param response
     */
    public void findSearch(HttpServletRequest request, HttpServletResponse response) {
        ResultState result = new ResultState();
        //搜索类型
        String searchType;
        //搜索内容
        String searchText = (String) request.getSession().getAttribute("searchText");
        System.out.println("搜索" + searchText);
        //搜索内容是否是某个组织
        boolean searchOrgFlag = false;
        List<Organizer> orgs = new ArrayList<>();
        List<String> actPicList = new ArrayList<>();
        boolean isAct = false;
        try {
            orgs = searchService.queryOrgsByName(searchText);
            searchOrgFlag = orgs.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            isAct = searchService.searchActivityByName(searchText) != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(searchOrgFlag);

        if (!searchOrgFlag) {
            //搜索组织
            searchType = "org";
            //查询对应的社团组织
            List<String> orgPicList = new ArrayList<>();
            List<String> infoList = new ArrayList<>();
            System.out.println("------------------" + orgs);
            for (Organizer organizer : orgs) {
                orgPicList.add(organizerService.selectHeadPortrait(organizer.getId()));
                infoList.add(organizerService.selectInfo(organizer.getId()));
            }
            result.getDatas().put("objList", orgs);
            result.getDatas().put("picList", orgPicList);
            result.getDatas().put("infoList", infoList);
            Integer size = orgs.size();
            result.getDatas().put("size", size);
            result.setCode(true);
            result.getDatas().put("searchType", searchType);
        } else if (isAct) {
            //搜索赛事活动标题
            searchType = "act";
            List<ActivityUser> actList = new ArrayList<>();
            List<String> infoList = new ArrayList<>();
            //查询对应的赛事活动
            try {
                actList = searchService.searchActivityByName(searchText);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (actList.size() != 0) {
                for (ActivityUser activityUser : actList) {
                    Integer id = activityUser.getId();
                    Pictures actMainPic = activityService.getActMainPic(id);
                    infoList.add(activityService.getInfoById(id));
                    if (actMainPic == null) {
                        actPicList.add(PictureController.PIC_BASE_URL + "image/default_match.jpg");
                    } else {
                        actPicList.add(actMainPic.getPicture());
                    }
                }
                result.getDatas().put("objList", actList);
                result.getDatas().put("infoList", infoList);
                result.getDatas().put("picList", actPicList);
                Integer size = actList.size();
                result.setCode(true);
                result.getDatas().put("size", size);
                result.getDatas().put("searchType", searchType);
            }
        }
        //使用json工具类返回结果
        JsonUtil.returnJson(response, result);
    }
}