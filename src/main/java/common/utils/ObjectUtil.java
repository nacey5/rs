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
    /**
     * 根据传入的类型获取对应的实例
     * @param request
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Object getObject(HttpServletRequest request, Class<T> t) {
        //判断 t 输入哪个类型
        if (t.isInstance(ActivityUser.class)) {
            ActivityUser activityUser = new ActivityUser();
            try {
                //BeanUtils工具类注入属性
                BeanUtils.populate(activityUser, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(activityUser);
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
