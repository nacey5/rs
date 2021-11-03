package pojo.dto;

import java.util.HashMap;
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
    private Map<String, Object> datas =new HashMap<>();

    public ResultState(String msg, boolean code, Map<String, Object> datas) {
        this.msg = msg;
        this.code = code;
        this.datas = datas;
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

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ResultState{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", datas=" + datas +
                '}';
    }
}
