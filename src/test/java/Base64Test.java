import common.utils.Base64Util;
import dao.ActivityDao;
import org.junit.Test;
import service.ActivityService;
import service.impl.ActivityServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author WEIR
 * @description
 * @date 18/10/2021 - 22:41
 */
public class Base64Test {

    @Test
    public static void main(String[] args) {
        String img = null;
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        img = Base64Util.toBase64(new File(file.getAbsolutePath() + "/src/main/webapp/image/zxb.jpg"));
        System.out.println(img);
        new ActivityServiceImpl().addPicture(0, img);
    }
}
