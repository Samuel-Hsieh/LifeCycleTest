package com.example.samuel.lifecyclestest;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.arch.lifecycle.ProcessLifecycleOwner;

/**
 * Created by samuel on 2018/5/18.
 */
public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks{

    int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        setupLifecycleListener();
    }

    private void setupLifecycleListener() {
        SampleListener lifecycleListener = new SampleListener();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(lifecycleListener);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        count++;
        Log.d("MyApplication","count: "+count);
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        count--;
        Log.d("MyApplication","count: "+count);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
