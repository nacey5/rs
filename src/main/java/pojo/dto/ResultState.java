package pojo.dto;

import java.util.List;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:57
 */
public class ResultState {
    //返回的信息
    private String msg;
    //返回的状态吗
    private boolean code = false;
    //可以放任何对象的map需要什么就存什么进去
    private Map<String, Object> data;

    public ResultState(String msg, boolean code, Map<String, Object> data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResultState() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
