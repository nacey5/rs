package controller;

import common.utils.Base64Util;
import common.utils.JsonUtil;
import enums.UploadEnum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 处理文件上传
 * @author 23931
 */
@WebServlet("/Upload")
public class UploadController extends HttpServlet {

    private static final ActivityService activityService = new ActivityServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private ResultState result = new ResultState();
    private Map<Integer, String> picMap = new HashMap<>();
    private static Integer id;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //获取图片
        findPictures(request);
        switch (action) {
            case UploadEnum.ADD_USER_IMG :{
                addUserImg(id,picMap.get(id));
                result.setCode(true);
                break;
            }
            case UploadEnum.ADD_ACTIVITY_PICTURE: {
                setActivityPic(id,picMap.get(id));
                result.setCode(true);
                break;
            }
            case UploadEnum.ADD_ACTIVITY_FILE:{

                break;
            }
            default: {
                result.setMsg("上传失败！");
                break;
            }
        }
        JsonUtil.returnJson(response,result);
    }

    /**
     * 获取请求上传的图片
     * @param request
     */
    public void findPictures(HttpServletRequest request) {
        String imgPath;
        File file = new File("");
        String basePath = file.getAbsolutePath() + "/src/main/webapp/image/";
        //上传得到用户或组织的id
        id = Integer.parseInt(request.getParameter("id"));
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    //获取上传的图片的保存路径
                    imgPath = basePath + fileItem.getName();
                    //转成 base64 存入picMap
                    picMap.put(id, Base64Util.toBase64((File) fileItem));
                    //保存图片
                    fileItem.write(new File(imgPath));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *添加用户头像
     * @param id
     * @param imgStr
     */
    public void addUserImg(Integer id,String imgStr) {
        userService.addUserImg(id,imgStr);
    }

    /**
     *添加组织图片
     * @param id
     * @param imgStr
     */
    public void setActivityPic(Integer id,String imgStr) {
        activityService.addPicture(id,imgStr);
    }

    public void setActivityFile(Integer id,String imgStr) {
//        activityService.(id,imgStr);
    }

}