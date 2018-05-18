package com.example.samuel.lifecyclestest;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by samuel on 2018/5/10.
 */
public class LifeCycleModel implements LifecycleObserver {

    private static final String TAG = LifeCycleModel.class.getName();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void LifeStart() {
        Log.d(TAG, "LifeStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void LifePause() {
        Log.d(TAG, "LifePause");
    }
}
