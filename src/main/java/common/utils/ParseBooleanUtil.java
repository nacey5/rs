package common.utils;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * 将String的数据类型转换成true||false
 */
public class ParseBooleanUtil {
    /**
     * 判断传入的String是否为true
     * @param s
     * @return
     */
    private static boolean parseBoolean(String s){
        return ((s!=null)&&s.equalsIgnoreCase("true"));
    }

    /**
     * 判断传入的数据是否为true，是的话返回boolean：true不是的话就返回boolean：false
     * @param s
     * @return
     */
    public static Boolean valueOf(String s){
        return parseBoolean(s)? TRUE:FALSE;
    }
}
