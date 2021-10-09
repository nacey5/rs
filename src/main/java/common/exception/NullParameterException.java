package common.exception;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 14:33
 */
public class NullParameterException extends Exception{
    /**
     *空参异常
     */
    public NullParameterException() {super("参数为空，出现错误！");}
}
