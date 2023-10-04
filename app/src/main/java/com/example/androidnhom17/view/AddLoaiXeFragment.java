package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentAddLoaiXeBinding;
import com.example.androidnhom17.viewmodel.AddLoaiXeViewModel;


public class AddLoaiXeFragment extends Fragment {
    FragmentAddLoaiXeBinding fragmentAddLoaiXeBinding;
    AddLoaiXeViewModel addLoaiXeViewModel = new AddLoaiXeViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddLoaiXeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_loai_xe,container,false);
        fragmentAddLoaiXeBinding.setAddLoaiXeViewModel(addLoaiXeViewModel);

        fragmentAddLoaiXeBinding.btnThemLoaiXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLoaiXeViewModel.handleAddLoaiXe(getContext());
            }
        });
        // Inflate the layout for this fragment
        return fragmentAddLoaiXeBinding.getRoot();
    }
}