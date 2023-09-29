package com.example.androidnhom17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.androidnhom17.databinding.ActivityUserManagerBinding;


public class UserManagerActivity extends AppCompatActivity {
    ActivityUserManagerBinding activityUserManagerBinding;
    UserManagerViewModel userManagerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        activityUserManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_manager);
        activityUserManagerBinding.setUserManagerViewModel(userManagerViewModel);



    }
}