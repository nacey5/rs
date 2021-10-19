package common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.*;

/**
 * @author WEIR
 * @description Base64转码工具类
 * @date 11/10/2021 - 14:05
 */
public class Base64Util {
    /**
     * 将文件转为 base64 编码
     *
     * @param file
     * @return
     */
    public static String toBase64(File file) {
        InputStream in;
        byte[] pic = null;
        try {
            in = new FileInputStream(file);
            pic = new byte[in.available()];
            in.read(pic);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BASE64Encoder().encode(pic);
    }

    /**
     * 将 base64 编码转为文件
     * @param base64
     * @param filePath
     */
    public static void fromBase64(String base64,String filePath) {
        if (filePath==null||"".equals(filePath)){
            return;
        }
        FileOutputStream os;
        byte[] bytes;
        try {
            bytes= new BASE64Decoder().decodeBuffer(base64);
            os=new FileOutputStream(filePath);
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

