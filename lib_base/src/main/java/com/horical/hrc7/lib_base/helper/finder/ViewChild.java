package com.horical.hrc7.lib_base.helper.finder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by quang.pv on 6/9/2017.
 */
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewChild {
    int value() default 0;

    String name() default "";
}
