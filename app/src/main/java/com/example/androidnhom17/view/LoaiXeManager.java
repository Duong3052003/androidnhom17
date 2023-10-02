package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.ActivityLoaiXeManagerBinding;
import com.example.androidnhom17.viewmodel.LoaiXeManagerViewModel;
import com.google.android.material.navigation.NavigationBarView;

public class LoaiXeManager extends AppCompatActivity {
    private boolean isRootFragmentAdded = false;
    ActivityLoaiXeManagerBinding activityLoaiXeManagerBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoaiXeManagerViewModel  loaiXeManagerViewModel = new LoaiXeManagerViewModel();
        activityLoaiXeManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_loai_xe_manager);
        activityLoaiXeManagerBinding.setLoaiXeManagerViewModel(loaiXeManagerViewModel);

        if (!isRootFragmentAdded) {
            // Nếu fragment gốc chưa được thêm vào, thêm nó vào container
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(activityLoaiXeManagerBinding.containerLoaiXeManager.getId(), ListLoaiXeFragment.class, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            // Đánh dấu rằng fragment gốc đã được thêm vào
            isRootFragmentAdded = true;
        }
        activityLoaiXeManagerBinding.menuThanhVienManager.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_show){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityLoaiXeManagerBinding.containerLoaiXeManager.getId(), ListLoaiXeFragment.class, null).addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if(item.getItemId() == R.id.action_add){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityLoaiXeManagerBinding.containerLoaiXeManager.getId(), AddLoaiXeFragment.class, null).addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }
}