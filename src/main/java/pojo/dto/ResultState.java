package pojo.dto;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 17:57
 */
public class ResultState {
    /**
     *
     */
    private String msg;
    /**
     *
     */
    private boolean code;

    public ResultState(String msg, boolean code) {
        this.msg = msg;
        this.code = code;
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

    @Override
    public String toString() {
        return "ResultState{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
