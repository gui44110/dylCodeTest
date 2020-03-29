package com.dyl.annotation;

import java.lang.annotation.*;

/**
 * @author dongyuliang
 * @date 2019-12-16 18:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface DemoAnnotation {

    String name() default "";

}
