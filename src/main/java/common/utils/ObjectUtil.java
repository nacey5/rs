package common.utils;

import org.apache.commons.beanutils.BeanUtils;
import pojo.bean.ActivityUser;
import pojo.bean.User;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 17:47
 */
public class ObjectUtil {

    public static <T> Object getObject(HttpServletRequest request, Class<T> t) {
        if (t.isInstance(ActivityUser.class)) {
            ActivityUser activityUser = new ActivityUser();
            try {
                //BeanUtils工具类注入属性
                BeanUtils.populate(activityUser, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return activityUser;
        }else if(t.isInstance(User.class)){
            User user = new User();
            try {
                //BeanUtils工具类注入属性
                BeanUtils.populate(user, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return user;
        }
        return null;
    }
}
