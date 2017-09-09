package com.mindorks.example.android_dagger2_example.di.component;

import android.app.Application;
import android.content.Context;

import com.mindorks.example.android_dagger2_example.DemoApplication;
import com.mindorks.example.android_dagger2_example.MainPresenter;
import com.mindorks.example.android_dagger2_example.data.DataManager;
import com.mindorks.example.android_dagger2_example.data.DbHelper;
import com.mindorks.example.android_dagger2_example.data.SharedPrefsHelper;
import com.mindorks.example.android_dagger2_example.di.module.InfoModule;
import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.module.ApplicationModule;
import com.mindorks.example.android_dagger2_example.di.scopes.ActivityScope;
import com.mindorks.example.android_dagger2_example.di.scopes.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class, InfoModule.class})
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();



    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();


}
