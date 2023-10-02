package com.example.androidnhom17;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.databinding.FragmentUserHomeBinding;

public class FillterUserFragment extends Fragment {
    FragmentUserHomeBinding fragmentUserHomeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentUserHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_home, container, false);

        HomeUserViewModel homeUserViewModel= new HomeUserViewModel("Duong2");
        fragmentUserHomeBinding.setHomeUserViewModel(homeUserViewModel);

        return fragmentUserHomeBinding.getRoot();

    }
}