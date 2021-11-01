package common.utils;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WEIR
 * @description json工具类
 * @date 8/10/2021 - 23:51
 */
public class JsonUtil {
    /**
     * 返回结果
     *
     * @param resp
     * @param o
     * @throws IOException
     */
    public static void returnJson(HttpServletResponse resp, Object o){
        Gson gson = new Gson();
        String json = gson.toJson(o);
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON");
    }
}
