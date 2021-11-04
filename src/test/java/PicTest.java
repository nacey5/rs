import org.junit.Test;
import pojo.bean.Organizer;
import service.OrganizerService;
import service.impl.OrganizerServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WEIR
 * @description
 * @date 2/11/2021 - 01:19
 */
public class PicTest {
    @Test
    public void setPic() {
//        ActivityServiceImpl activityService = new ActivityServiceImpl();
        OrganizerService organizerService = new OrganizerServiceImpl();
//        UserService userService = new UserServiceImpl();
//        List<String> picList = new ArrayList<>();
//        picList.add(PictureController.PIC_BASE_URL + "image/zxb.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/xshzx_0.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/shetuanzhaoxin_0.jpg");
//        picList.add(PictureController.PIC_BASE_URL + "image/zuzishetuan.jpg");
//        for (String s : picList) {
//            activityService.addPicture(0,s);
//        }
//        activityService.addPicture(2, picList.get(0));
//        activityService.addPicture(3, picList.get(1));
//        for (Pictures pictures : activityService.getPicture(0)) {
//            System.out.println(pictures);
//        }
//        userService.register(new User(201543001,Md5Util.getMd5String("123d"),"13126021981"));
        // activityService.addPicture(2,"asdaddadad");
//        userService.login("13012344321", "123456");
//        System.out.println(userService.queryUserInfo().toString());
//        organizerService.orgRegister(new Organizer("小行星", 0, 201643239,
//                "13053211234", "123456", null, null));
        Organizer organizer = organizerService.orgLogin("13053211234", "123456");
        System.out.println(organizer);

        System.out.println(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
    }
}
