package com.mindorks.example.android_dagger2_example.di.module;

import android.app.Activity;

import com.mindorks.example.android_dagger2_example.MainContract;
import com.mindorks.example.android_dagger2_example.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 6.9.2017..
 */
@Module(includes = ActivityModule.class)
public class MainActivityModule {
    @Provides
    @ActivityScope
    MainContract provideMainContract(Activity activity) {
        return (MainContract)activity;
    }
}
