package com.mindorks.example.android_dagger2_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.example.android_dagger2_example.data.DataManager;
import com.mindorks.example.android_dagger2_example.data.SharedPrefsHelper;
import com.mindorks.example.android_dagger2_example.data.model.User;

import com.mindorks.example.android_dagger2_example.di.component.DaggerMainActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.MainActivityComponent;
import com.mindorks.example.android_dagger2_example.di.module.ActivityModule;
import com.mindorks.example.android_dagger2_example.di.qualifier.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity implements MainContract {

    @Inject
    DataManager mDataManager;
    @Inject
    MainPresenter mPresenter;
    @Inject
    SharedPrefsHelper sharedPrefsHelper;



    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    private MainActivityComponent activityComponent;
    public MainActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerMainActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
