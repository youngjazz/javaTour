package annotation;

import java.lang.annotation.*;

/**
 * Created by leon on 2017/5/8.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Colum {
    String value() default "fieldName";

    String getFunctionName() default "setField";

    String getFuncName() default "getField";

    boolean defaultDBValue() default false;
}
