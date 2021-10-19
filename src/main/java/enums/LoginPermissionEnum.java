package enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 15/10/2021 - 12:12
 * @author DAHUANG
 * @description 设置过滤器放行文件的后缀名，用于无权限的游客或者用户访问
 */
public class  LoginPermissionEnum {
    //设置放行的的后缀
    public static final Set<String> CHECK_MAP= Collections.unmodifiableSet(
            /**
             * 所登陆权限的用户可以访问的页面在此定义
             */
            new HashSet<>(Arrays.asList("/add"))
    );


}
