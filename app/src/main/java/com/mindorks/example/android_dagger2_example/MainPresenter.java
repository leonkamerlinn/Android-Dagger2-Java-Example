package com.mindorks.example.android_dagger2_example;

import android.content.Context;
import android.widget.Toast;

import com.mindorks.example.android_dagger2_example.di.qualifier.ActivityContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.qualifier.DatabaseInfo;
import com.mindorks.example.android_dagger2_example.di.scopes.ActivityScope;
import com.mindorks.example.android_dagger2_example.di.scopes.ApplicationScope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Leon on 6.9.2017..
 */
@ActivityScope
public class MainPresenter {
    private final MainContract mView;
    private final Context mContext;





    @Inject
    public MainPresenter(MainContract view, @ActivityContext Context context) {
        mView = view;
        mContext = context;
        mView.showToast("Hello from Activity");

    }

    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

}
