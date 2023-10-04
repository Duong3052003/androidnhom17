package com.example.androidnhom17.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.androidnhom17.adapter.ChuyenXeAdapter;
import com.example.androidnhom17.config.AppDatabase;

public class ListChuyenXeViewModel extends BaseObservable {
    private ChuyenXeAdapter chuyenXeAdapter;
    public void renderAdapter(Context context){
        chuyenXeAdapter = new ChuyenXeAdapter(context);
        chuyenXeAdapter.setData(AppDatabase.getInstance(context).getChuyenXeDAO().getAll());
        this.setChuyenXeAdapter(chuyenXeAdapter);
    }

    public ChuyenXeAdapter getChuyenXeAdapter() {
        return chuyenXeAdapter;
    }

    public void setChuyenXeAdapter(ChuyenXeAdapter chuyenXeAdapter) {
        this.chuyenXeAdapter = chuyenXeAdapter;
    }
}