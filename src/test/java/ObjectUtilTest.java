import common.utils.ObjectUtil;
import org.apache.commons.beanutils.BeanUtils;
import pojo.bean.User;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 15/10/2021 - 14:18
 */
public class ObjectUtilTest {
    public static void main(String[] args) {
        User user=new User();
        Map<String,String>map=new HashMap<>();
        map.put("id","1");
        map.put("name","ss");
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
