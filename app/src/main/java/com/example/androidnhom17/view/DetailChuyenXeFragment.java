package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentDetailChuyenXeBinding;
import com.example.androidnhom17.model.ChuyenXe;
import com.example.androidnhom17.viewmodel.DetailChuyenXeViewModel;

public class DetailChuyenXeFragment extends Fragment {

    FragmentDetailChuyenXeBinding fragmentDetailChuyenXeBinding;
    DetailChuyenXeViewModel detailChuyenXeViewModel = new DetailChuyenXeViewModel();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentDetailChuyenXeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_chuyen_xe,container,false);
        fragmentDetailChuyenXeBinding.setDetailChuyenXeViewModel(detailChuyenXeViewModel);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ChuyenXe chuyenXe = (ChuyenXe) bundle.getSerializable("chuyenXe");
            detailChuyenXeViewModel.setDetailChuyenXe(chuyenXe, getContext());
            String imageUrl =  chuyenXe.getHinhAnh();
            Glide.with(this.getContext())
                    .load(imageUrl)
                    .into(fragmentDetailChuyenXeBinding.imgChuyenXe);
        }




        return fragmentDetailChuyenXeBinding.getRoot();
    }


}