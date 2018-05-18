package com.example.samuel.lifecyclestest.ReqApi;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by samuel on 2018/5/18.
 */
@Retention(RUNTIME)
@Target(PARAMETER)
public @interface ReqParam {

    String value();

}
