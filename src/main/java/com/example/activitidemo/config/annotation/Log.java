package com.example.activitidemo.config.annotation;


import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String operationType() default "默认无操作类型";

    String operationName() default "默认无操作名称";

}
