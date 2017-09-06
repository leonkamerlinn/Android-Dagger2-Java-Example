package com.mindorks.example.android_dagger2_example.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 6.9.2017..
 */
@Module(includes = ApplicationModule.class)
public class InfoModule {
    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs(@ApplicationContext Context context) {
        return context.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
