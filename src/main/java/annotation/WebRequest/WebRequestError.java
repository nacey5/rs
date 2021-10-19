package annotation.WebRequest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在类名进行注解，访问失败时候访问的失败路径是什么
 * 在default里面写入访问失败跳转的地址
 * @author DAHUANG
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebRequestError {
    String value() default "";
}
