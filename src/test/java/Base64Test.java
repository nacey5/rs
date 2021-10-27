import common.utils.Base64Util;

import org.junit.Test;
import service.impl.ActivityServiceImpl;

import java.io.File;

/**
 * @author WEIR
 * @description
 * @date 18/10/2021 - 22:41
 */
public class Base64Test {

    @Test
    public void test() {
        String img = null;
        File file = new File("");
//        System.out.println(file.getAbsolutePath());
        img = Base64Util.toBase64(new File(file.getAbsolutePath() + "/src/main/webapp/image/zxb.jpg"));
//        System.out.println(img);
        new ActivityServiceImpl().addPicture(7, "sssssssssssssssssssssssssssssss");
        System.out.println(new ActivityServiceImpl().getPicture(2));
    }
}
