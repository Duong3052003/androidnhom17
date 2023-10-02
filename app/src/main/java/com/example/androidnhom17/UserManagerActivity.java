package com.example.androidnhom17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.androidnhom17.databinding.ActivityUserManagerBinding;
import com.google.android.material.navigation.NavigationBarView;


public class UserManagerActivity extends AppCompatActivity {
    ActivityUserManagerBinding activityUserManagerBinding;
    UserManagerViewModel userManagerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUserManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_manager);
        activityUserManagerBinding.setUserManagerViewModel(userManagerViewModel);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(activityUserManagerBinding.framelayoutuser.getId(), new HomeUserFragment());
        fragmentTransaction.commit();

        activityUserManagerBinding.containerBtn.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityUserManagerBinding.framelayoutuser.getId(),new HomeUserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                } else if (itemId == R.id.account) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityUserManagerBinding.framelayoutuser.getId(),new HomeUserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }else if (itemId == R.id.filter) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityUserManagerBinding.framelayoutuser.getId(),new FillterUserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (itemId == R.id.history) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityUserManagerBinding.framelayoutuser.getId(),new HomeUserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }

                return false;
            }
        });


    }
}