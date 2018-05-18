package com.example.samuel.lifecyclestest.ReqApi;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by samuel on 2018/5/18.
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface ReqType {

    enum ReqTypeEnum {GET, POST, DELETE, PUT}

    ReqTypeEnum reqType() default ReqTypeEnum.POST;
}
