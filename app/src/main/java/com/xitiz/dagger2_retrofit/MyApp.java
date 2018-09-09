package com.xitiz.dagger2_retrofit;

import android.app.Application;

import com.xitiz.dagger2_retrofit.di.ApiComponent;
import com.xitiz.dagger2_retrofit.di.ApiModule;
import com.xitiz.dagger2_retrofit.di.AppModule;
import com.xitiz.dagger2_retrofit.di.DaggerApiComponent;

public class MyApp extends Application {
    ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .appModule(new AppModule(this))
                .build();
    }

    public ApiComponent getNetComponent() {
        return apiComponent;
    }
}
