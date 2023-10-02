package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentDetailLoaiXeBinding;
import com.example.androidnhom17.model.LoaiXe;
import com.example.androidnhom17.viewmodel.DetailLoaiXeViewModel;


public class DetailLoaiXeFragment extends Fragment {
    FragmentDetailLoaiXeBinding fragmentDetailLoaiXeBinding;
    DetailLoaiXeViewModel detailLoaiXeViewModel = new DetailLoaiXeViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentDetailLoaiXeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail_loai_xe,container,false);
        fragmentDetailLoaiXeBinding.setDetailLoaiXeViewModel(detailLoaiXeViewModel);

        Bundle bundle = getArguments();
        if (bundle != null) {
            LoaiXe loaiXe = (LoaiXe) bundle.getSerializable("loaiXe");
            detailLoaiXeViewModel.setDetailLoaiXe(loaiXe, getContext());
        }
        return fragmentDetailLoaiXeBinding.getRoot();

     }
}