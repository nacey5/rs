package controller;

import common.utils.JsonUtil;
import enums.UploadEnum;
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

/**
 * @author 23931
 * @description 处理文件上传
 */
@WebServlet("/Upload")
public class UploadController extends HttpServlet {

    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private ResultState result = new ResultState();
    private static Integer id;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //获取图片
        Pictures uploadPic = (Pictures) upload(request, Pictures.class);
        switch (action) {
            case UploadEnum.ADD_USER_IMG: {
                addUserImg(id, uploadPic.getPicture());
                result.setCode(true);
                break;
            }
            case UploadEnum.ADD_ACTIVITY_PICTURE: {
                setActivityPic(id, uploadPic.getPicture());
                result.setCode(true);
                break;
            }
            case UploadEnum.ADD_ACTIVITY_FILE: {

                break;
            }
            default: {
                result.setMsg("上传图片失败！");
                break;
            }
        }
        JsonUtil.returnJson(response, result);
    }

    /**
     * 获取请求上传的图片
     *
     * @param request
     */
    public <T> Object upload(HttpServletRequest request, Class<T> tClass) {
        String imgPath;
        List<String> msgList = new ArrayList<>();
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // 遍历判断每一个表单项，是普通类型，还是上传的图片
                for (FileItem fileItem : list) {
                    // 普通表单项
                    if (fileItem.isFormField()) {
                        // 设置UTF-8，解决乱码问题，存入字符数组
                        msgList.add(fileItem.getString("UTF-8"));
                    } else {
                        //上传的图片
                        imgPath = "image/" + fileItem.getName();
                        //获取保存路径
                        String imgSavePath = PictureController.PIC_BASE_URL + imgPath;
                        //保存图片
                        fileItem.write(new File(imgSavePath));
                        //返回图片路径
                        return imgSavePath;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
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