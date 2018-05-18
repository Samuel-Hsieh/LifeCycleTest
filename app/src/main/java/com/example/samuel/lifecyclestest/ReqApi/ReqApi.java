package com.example.samuel.lifecyclestest.ReqApi;


import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by samuel on 2018/5/18.
 */

public class ReqApi implements IReqApi {

    public interface ApiCallback {
        void StringCallback(String s);
    }

    /**
     * class內method用annotation
     */
    @ReqUrl(reqUrl = "Dfffff")
    public void SSS() {

    }

    @Override
    public String login(String userId, String pwd, ApiCallback callback) {
        callback.StringCallback("");

        Method method = getClass().getInterfaces()[0].getMethods()[0];
//            Method method = getClass().getMethod("SSS");
        if (method.isAnnotationPresent(ReqUrl.class)) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation.annotationType() == ReqType.class) {
                    Log.d("SDfsdfsd", "reqType: " + ((ReqType) annotation).reqType());
                } else if (annotation.annotationType() == ReqUrl.class) {
                    Log.d("SDfsdfsd", "ReqUrl: " + ((ReqUrl) annotation).reqUrl());
                }
            }
        }
        return "";
    }
}

