package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.androidnhom17.R;
import com.example.androidnhom17.config.FunctionPublic;
import com.example.androidnhom17.databinding.FragmentHomeUserBinding;
import com.example.androidnhom17.viewmodel.HomeUserViewModel;


public class HomeUserFragment extends Fragment {

    FragmentHomeUserBinding fragmentHomeUserBinding;
    HomeUserViewModel homeUserViewModel = new HomeUserViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_user, container,false);
        // Inflate the layout for this fragment
        fragmentHomeUserBinding.setHomeUserViewModel(homeUserViewModel);
        homeUserViewModel.getWelcome(getContext());
        FunctionPublic.loadImage(homeUserViewModel.getAvatar(),fragmentHomeUserBinding.avatarImg,getContext());

//        slide ở đây
        fragmentHomeUserBinding.imageSlider.setImageList(homeUserViewModel.listImage(), ScaleTypes.FIT);

//        render ra adapter

        setAdapterForChuyenXe();
        return fragmentHomeUserBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setAdapterForChuyenXe();
    }

    private void setAdapterForChuyenXe(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeUserBinding.rcvChuyenXe.setLayoutManager(linearLayoutManager);
        homeUserViewModel.renderAdapter(getContext());
        fragmentHomeUserBinding.rcvChuyenXe.setAdapter(homeUserViewModel.getChuyenXeUserAdapter());
    }
}