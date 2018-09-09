package com.xitiz.dagger2_retrofit.di;

import com.xitiz.dagger2_retrofit.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity mainActivity);

}
