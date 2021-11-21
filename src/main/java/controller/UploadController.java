package controller;

import common.utils.JsonUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.bean.Pictures;
import pojo.dto.ResultState;
import service.ActivityService;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 23931
 * @description 处理文件上传
 */
@WebServlet("/Upload")
public class UploadController extends HttpServlet {
    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static ResultState result = new ResultState();
    private static Integer id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());
        String action = request.getParameter("addType");
        //获取图片
        Pictures uploadPic = (Pictures) upload(request);
        System.out.println(uploadPic.getPicture());
//        switch (action) {
//            case UploadEnum.ADD_USER_IMG: {
//                addUserImg(id, uploadPic.getPicture());
//                result.setCode(true);
//                break;
//            }
//            case UploadEnum.ADD_ACTIVITY_PICTURE: {
//                setActivityPic(id, uploadPic.getPicture());
//                result.setCode(true);
//                break;
//            }
//            case UploadEnum.ADD_ACTIVITY_FILE: {
//
//                break;
//            }
//            default: {
//                result.setMsg("上传图片失败！");
//                break;
//            }
//        }
        JsonUtil.returnJson(response, result);
        System.out.println(result.toString());
    }

    /**
     * 获取请求上传的图片
     *
     * @param request
     */
    public static <T> Object upload(HttpServletRequest request) {
        Pictures pic = new Pictures(-1, "");
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                System.out.println(list);
                // 遍历判断每一个表单项，是普通类型，还是上传的图片
                for (FileItem fileItem : list) {
                    // 普通表单项
                    if (fileItem.isFormField()) {
                        // 设置UTF-8，解决乱码问题，存入字符数组
                        System.out.println("普通");
                        //如果类型是活动的话,将数据添加到actList中
                    } else {
                        //上传的图片
                        //获取保存路径
                        String imgSavePath = request.getServletContext().getRealPath("/") + "image\\" + fileItem.getName();
                        //保存图片
                        fileItem.write(new File(imgSavePath));
                        //返回图片
                        pic.setPicture(imgSavePath);
                        System.out.println("上传成功！");
                        result.setCode(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pic;
    }

    /**
     * 添加用户头像
     *
     * @param id
     * @param imgStr
     */
    public void addUserImg(Integer id, String imgStr) {
        userService.addUserImg(id, imgStr);
    }

    /**
     * 添加组织图片
     *
     * @param id
     * @param imgStr
     */
    public void setActivityPic(Integer id, String imgStr) {
        activityService.addPicture(id, imgStr);
    }

    public void setActivityFile(Integer id, String imgStr) {
//        activityService.(id,imgStr);
    }

}