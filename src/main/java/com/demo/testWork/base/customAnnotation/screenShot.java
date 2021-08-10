package com.demo.testWork.base.customAnnotation;

import java.lang.annotation.*;

/**
 *
 * 自定义截图注解，作用在page中的方法
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface screenShot {
   boolean value() default true;
}
