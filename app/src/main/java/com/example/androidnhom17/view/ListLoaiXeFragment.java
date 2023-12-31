package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentListLoaiXeBinding;
import com.example.androidnhom17.viewmodel.ListLoaiXeViewModel;

public class ListLoaiXeFragment extends Fragment {
    private ListLoaiXeViewModel listLoaiXeViewModel = new ListLoaiXeViewModel();
    private  FragmentListLoaiXeBinding fragmentListLoaiXeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListLoaiXeBinding fragmentListLoaiXeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_loai_xe,container,false);
        // Inflate the layout for this fragment
        fragmentListLoaiXeBinding.setListLoaiXeViewModel(listLoaiXeViewModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        fragmentListLoaiXeBinding.rcvLoaiXe.setLayoutManager(linearLayoutManager);
        listLoaiXeViewModel.renderAdapter(getContext());
        fragmentListLoaiXeBinding.rcvLoaiXe.setAdapter(listLoaiXeViewModel.getLoaiXeAdapter());
        fragmentListLoaiXeBinding.searchTenXe.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listLoaiXeViewModel.getLoaiXeAdapter().getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listLoaiXeViewModel.getLoaiXeAdapter().getFilter().filter(newText);
                return false;
            }

        });

        fragmentListLoaiXeBinding.rcvLoaiXe.setLayoutManager(linearLayoutManager);
        listLoaiXeViewModel.renderAdapter(getContext());
        fragmentListLoaiXeBinding.rcvLoaiXe.setAdapter(listLoaiXeViewModel.getLoaiXeAdapter());

        return fragmentListLoaiXeBinding.getRoot();
    }
}