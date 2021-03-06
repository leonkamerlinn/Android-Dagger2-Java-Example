package com.mindorks.example.android_dagger2_example.di.module;

import android.app.Activity;
import android.content.Context;

import com.mindorks.example.android_dagger2_example.MainContract;
import com.mindorks.example.android_dagger2_example.MainPresenter;
import com.mindorks.example.android_dagger2_example.di.qualifier.ActivityContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.DatabaseInfo;
import com.mindorks.example.android_dagger2_example.di.scopes.ActivityScope;

import java.util.Random;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 08/12/16.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }


    @Provides
    @DatabaseInfo
    int provideRandom() {
        int min = 10;
        int max = 80;

        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;
        return i1;
    }
}
