package common.utils;

import common.exception.NullParameterException;

/**
 * @author WEIR
 * @date 8/10/2021 - 15:17
 */
public class WebUtil {

    public static int parseInt(String str) throws NullParameterException {

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new NullParameterException();
        }
    }
}
