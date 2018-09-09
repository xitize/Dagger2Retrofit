package com.xitiz.dagger2_retrofit.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }


    @Singleton
    @Provides
    Application provideApplication() {
        return application;
    }
}
