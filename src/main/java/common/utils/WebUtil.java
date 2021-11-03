package common.utils;

import javax.servlet.http.HttpServletRequest;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author WEIR
 * @date 8/10/2021 - 15:17
 */
public class WebUtil {

    /**
     * 获取验证码
     * @param request
     * @return
     */
    public static String getCode(HttpServletRequest request){
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println("验证码为："+token);
        // 删除 Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        return token;
    }
}
