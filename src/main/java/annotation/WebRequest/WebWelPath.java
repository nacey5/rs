package annotation.WebRequest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在方法名定义，设置默认的访问路径
 * 在defalut写入默认的访问路径，方便跳转
 * @author DAHUANG
 */
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface WebWelPath{
    String value() default "";
}


