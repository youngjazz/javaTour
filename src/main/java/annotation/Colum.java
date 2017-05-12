package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
