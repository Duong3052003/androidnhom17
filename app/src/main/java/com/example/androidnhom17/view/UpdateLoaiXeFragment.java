package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentUpdateLoaiXeBinding;
import com.example.androidnhom17.model.LoaiXe;
import com.example.androidnhom17.viewmodel.UpdateLoaiXeViewModel;

public class UpdateLoaiXeFragment extends Fragment {


    private FragmentUpdateLoaiXeBinding fragmentUpdateLoaiXeBinding;
    private UpdateLoaiXeViewModel updateLoaiXeViewModel = new UpdateLoaiXeViewModel();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentUpdateLoaiXeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_update_loai_xe,container,false);
        fragmentUpdateLoaiXeBinding.setUpdateLoaiXeViewModel(updateLoaiXeViewModel);
        Bundle bundle = getArguments();

        if (bundle != null) {
            LoaiXe loaiXe = (LoaiXe) bundle.getSerializable("loaiXe");
            updateLoaiXeViewModel.showDetaiLoaiXe(loaiXe,getContext());
            fragmentUpdateLoaiXeBinding.btnUpdateLoaiXe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    updateLoaiXeViewModel.updateLoaiXe(loaiXe,getContext());
                }
            });
        }


        return fragmentUpdateLoaiXeBinding.getRoot();
     }

}