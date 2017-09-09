package com.mindorks.example.android_dagger2_example.di.component;

import com.mindorks.example.android_dagger2_example.MainActivity;
import com.mindorks.example.android_dagger2_example.di.module.ActivityModule;
import com.mindorks.example.android_dagger2_example.di.module.InfoModule;
import com.mindorks.example.android_dagger2_example.di.module.MainActivityModule;
import com.mindorks.example.android_dagger2_example.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
