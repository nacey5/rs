package controller;

import common.utils.JsonUtil;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import pojo.bean.Pictures;
import pojo.dto.ResultState;
import service.ActivityService;
import service.OrganizerService;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.OrganizerServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WEIR
 * @description 获取各种图片
 * @date 20/10/2021 - 16:51
 */
@WebServlet("/Picture")
public class PictureController extends BaseController {
//    public static final String PIC_BASE_URL = "http://rsrs.nat300.top/FindMore/";
            public static final String PIC_BASE_URL = "http://localhost:8080/FindMore/";
    private static final UserService userService = new UserServiceImpl();
    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final OrganizerService organizerService = new OrganizerServiceImpl();
    private ResultState result = new ResultState();

    /**
     * 获取*****首页****轮播图的图片
     *
     * @param request
     * @param response
     */
    public void getMatchAndOrgPic(HttpServletRequest request, HttpServletResponse response) {
        //获取查询到的图片
        List<Pictures> pictures = activityService.getPicture(0);
        //创建图片路径的字符串数组
        List<String> picList = new ArrayList<>();
        for (Pictures picture : pictures) {
            picList.add(picture.getPicture());
        }
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取*****指定赛事*****的图片
     *
     * @param request
     * @param response
     */
//    @RequestMapping(value="")
    public void getMatchPic(HttpServletRequest request, HttpServletResponse response) {

        int id = (int) request.getSession().getAttribute("id");
        //获取查询到的图片
        List<Pictures> pictures = activityService.getPicture(id);
        //创建图片路径的字符串数组
        List<String> picList = new ArrayList<>();
        for (Pictures picture : pictures) {
            picList.add(picture.getPicture());
        }
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    public void getIndexMatchPic(HttpServletRequest request, HttpServletResponse response) {
        List<String> picList = new ArrayList<>();
        picList.add(PIC_BASE_URL + "image/knowledge.jpg");
        picList.add(PIC_BASE_URL + "image/sport.jpg");
        picList.add(PIC_BASE_URL + "image/love.jpg");
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        System.out.println(picList.toString());
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    public void getIndexOrgPic(HttpServletRequest request, HttpServletResponse response) {

        List<String> picList = new ArrayList<>();
        picList.add(PIC_BASE_URL + "image/lunhua.jpg");
        picList.add(PIC_BASE_URL + "image/lanqiu.jpg");
        picList.add(PIC_BASE_URL + "image/sheying.jpg");
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        System.out.println(picList.toString());
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取*****赛事*****轮播图中的图片
     *
     * @param request
     * @param response
     */
    public void getMatchPicList(HttpServletRequest request, HttpServletResponse response) {

        List<String> picList = new ArrayList<>();
        //查询活动并且遍历
//        for (ActivityUser activityUser : activityService.getActivity(0, 3)) {
//            //获取对于的图片数组
//            List<Pictures> picture = activityService.getPicture(activityUser.getId());
//            //取第一张添加
//            picList.add(picture.get(0).getPicture());
//        }

        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取****社团组织****轮播图中的图片
     *
     * @param request
     * @param response
     */
    public void getOrgPicList(HttpServletRequest request, HttpServletResponse response) {

        List<String> picList = new ArrayList<>();
        List<String> infoList = new ArrayList<>();
        for (Organizer org : organizerService.getOrgs(0,3)) {
            //获取对应的图片数组，获取头像(图片)
            String picture = org.getHeadPortrait();
            picList.add(picture);
            infoList.add(org.getInfo());
        }
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        result.getDatas().put("infoList", infoList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取赛事活动页面中的图片
     *
     * @param request
     * @param response
     */
    public void getMatchList(HttpServletRequest request, HttpServletResponse response) {
        String matchType = request.getParameter("matchType");
        List<String> picList = new ArrayList<>();
        List<ActivityUser> actList = new ArrayList<>();
        List<String> infoList = new ArrayList<>();

        switch (matchType) {
            case "sport": {
                actList = activityService.getActsByLevel(0);
                break;
            }
            case "knowledge": {
                actList = activityService.getActsByLevel(1);
                break;
            }
            case "volunteering": {
                actList = activityService.getActsByLevel(2);
                break;
            }
            default:
                break;
        }
        for (ActivityUser activityUser : actList) {
            //获取对应的图片数组，获取info
            picList.add(activityService.getActMainPic(activityUser.getId()).getPicture());
            infoList.add(activityUser.getInfo());
        }
        //往结果里面存图片数组、信息数组
        result.getDatas().put("picList", picList);
        result.getDatas().put("infoList", infoList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }

    /**
     * 点击社团组织页面的“换一批”
     *
     * @param request
     * @param response
     */
    public void getOrgList(HttpServletRequest request, HttpServletResponse response) {

        List<String> picList = new ArrayList<>();
        List<String> infoList = new ArrayList<>();
        List<Organizer> orgs = null;
        try {
            orgs = organizerService.getOrgs(0, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(orgs);
        for (Organizer organizer : orgs) {
            //获取对应的图片数组，获取头像(图片)
            String picture = organizer.getHeadPortrait();
            picList.add(picture);
            infoList.add( organizerService.selectInfo(organizer.getId()));
        }
        //往结果里面存图片数组
        result.getDatas().put("picList", picList);
        result.getDatas().put("infoList", infoList);
        //调用工具类返回结果
        JsonUtil.returnJson(response, result);
    }
}
