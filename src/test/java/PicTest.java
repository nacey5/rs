import org.junit.Test;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import service.OrganizerService;
import service.UserService;
import service.impl.ActivityServiceImpl;
import service.impl.OrganizerServiceImpl;
import service.impl.SearchServiceImpl;
import service.impl.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        OrganizerService organizerService = new OrganizerServiceImpl();
        UserService userService = new UserServiceImpl();
        SearchServiceImpl searchService = new SearchServiceImpl();
        List<String> strings = searchService.searchByKeyWords("");
        System.out.println(strings);
    }
}
