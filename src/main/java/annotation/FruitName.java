package annotation;

import java.lang.annotation.*;

/**
 * Created by yang.zhang on 2017/5/8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
