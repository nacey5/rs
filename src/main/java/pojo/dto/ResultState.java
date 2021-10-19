package pojo.dto;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:57
 */
public class ResultState {

    private String msg;
    private boolean code = false;
    private List<String> picLists;

    public ResultState(String msg, boolean code,List<String> picLists) {
        this.msg = msg;
        this.code = code;
        this.picLists = picLists;
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

    public List<String> getPicLists() {
        return picLists;
    }

    public void setPicLists(List<String> picLists) {
        this.picLists = picLists;
    }
}
