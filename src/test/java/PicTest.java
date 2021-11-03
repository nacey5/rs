import controller.PictureController;
import org.junit.Test;
import pojo.bean.Pictures;
import pojo.bean.User;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 2/11/2021 - 01:19
 */
public class PicTest {
    @Test
    public void setPic() {
        ActivityServiceImpl activityService = new ActivityServiceImpl();
//        List<String> picList = new ArrayList<>();
//        picList.add(PictureController.PIC_BASE_URL + "image/zxb.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/xshzx_0.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/shetuanzhaoxin_0.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/zuzishetuan.jpg");
//        for (String s : picList) {
//            activityService.addPicture(0,s);
//        }
//        activityService.addPicture(2, picList.get(0));
//
////        activityService.addPicture(3, picList.get(1));
//        for (Pictures pictures : activityService.getPicture(0)) {
//            System.out.println(pictures);
//        }
        UserService userService=new UserServiceImpl();
        userService.register(new User(201543239,"123d","13068524158"));
       // activityService.addPicture(2,"asdaddadad");
    }
}
