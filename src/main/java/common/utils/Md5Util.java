package common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author WEIR
 * @description Md5加密工具类
 * @date 9/10/2021 - 16:03
 */
public class Md5Util {
    /**
     * 进行Md5加密
     * @param str
     * @return
     */
    public static String getMd5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 计算md5函数
            System.out.println(md5+"555");
            System.out.println(str+"666");
            md5.update(str.getBytes());
            //32位加密
            return new BigInteger(1, md5.digest()).toString(32);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
