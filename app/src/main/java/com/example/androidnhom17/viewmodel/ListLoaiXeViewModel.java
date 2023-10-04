package com.example.androidnhom17.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.androidnhom17.adapter.LoaiXeAdapter;
import com.example.androidnhom17.config.AppDatabase;

public class ListLoaiXeViewModel extends BaseObservable {
    private LoaiXeAdapter loaiXeAdapter;
    public void renderAdapter(Context context){
        loaiXeAdapter = new LoaiXeAdapter(context);
        loaiXeAdapter.setData(AppDatabase.getInstance(context).getLoaiXeDAO().getAll());
        this.setLoaiXeAdapter(loaiXeAdapter);
    }

    public LoaiXeAdapter getLoaiXeAdapter() {
        return loaiXeAdapter;
    }

    public void setLoaiXeAdapter(LoaiXeAdapter loaiXeAdapter) {
        this.loaiXeAdapter = loaiXeAdapter;
    }
}
