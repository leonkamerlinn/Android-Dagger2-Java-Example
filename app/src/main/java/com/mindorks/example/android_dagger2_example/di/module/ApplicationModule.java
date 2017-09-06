package com.mindorks.example.android_dagger2_example.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 25/12/16.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }




}
