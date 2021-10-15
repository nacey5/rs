package common.utils;

/**
 * @author WEIR
 * @date 8/10/2021 - 15:17
 */
public class WebUtil {

    public static int parseInt(String str,int defaultValue) {

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
