package com.example.samuel.lifecyclestest;

import android.app.ActivityManager;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.samuel.lifecyclestest.ReqApi.IReqApi;
import com.example.samuel.lifecyclestest.ReqApi.ReqApi;
import com.example.samuel.lifecyclestest.ReqApi.ReqType;
import com.example.samuel.lifecyclestest.ReqApi.ReqUrl;

import java.lang.annotation.Annotation;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LifecycleRegistry mLifecycleRegistry;
    private LifeCycleModel model;
    private LifeCycleModel2 model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLifecycleRegistry = new LifecycleRegistry(this);
        model = new LifeCycleModel();
        model2 = new LifeCycleModel2();
        getLifecycle().addObserver(model);
        getLifecycle().addObserver(model2);
        Log.d("dgfdgdf", "Dfgdfgdf: " + reverse(8111111111L));
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        ReqApi api = new ReqApi();
        api.login("Sdfsd", "sfsdf", new ReqApi.ApiCallback() {
            @Override
            public void StringCallback(String s) {
                Log.d("dgfdgdf", "Dfgdfgdf: " + s);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.class.getName(), "onStop");
        if (isAppOnBackground()) {
            Log.d(MainActivity.class.getName(), "isAppOnBackground = true");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","onDestroy");
    }

    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Override
    protected void onRestart() {
        Log.d("onRestart","before: "+isAppOnBackground());
        super.onRestart();
        Log.d("MainActivity_onRestart","after");

    }

    public int reverse(long num) {
        long result = 0;
        while (num != 0) {
            result = result * 10;
            result = result + (num % 10);
            num = num / 10;
        }
        int test = (int) result;
        if (test == result) return test;
        return 0;
    }

    public boolean isAppOnBackground() {
        ActivityManager am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = am.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                return true;
            }
        }

        return false;
    }
}