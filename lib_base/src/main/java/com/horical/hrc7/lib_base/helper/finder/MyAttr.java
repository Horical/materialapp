package com.horical.hrc7.lib_base.helper.finder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by HRC7 on 7/6/2017.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAttr {
    int id() default -1;

    String name() default "";

    byte type();

    int defInt() default 0;

    float defFloat() default 0f;

    boolean defBool() default false;
}
