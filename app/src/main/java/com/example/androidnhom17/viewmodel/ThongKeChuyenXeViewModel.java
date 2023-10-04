package com.example.androidnhom17.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.androidnhom17.adapter.ThongKeChuyenXeAdapter;
import com.example.androidnhom17.config.AppDatabase;
import com.example.androidnhom17.model.ChuyenXe;
import com.example.androidnhom17.model.DAO.ChuyenXeDAO;

import java.util.List;

public class ThongKeChuyenXeViewModel extends BaseObservable {
    private ThongKeChuyenXeAdapter thongKeChuyenXeAdapter;

    public void renderAdapter(Context context){
        thongKeChuyenXeAdapter = new ThongKeChuyenXeAdapter(context);
        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(context).getChuyenXeDAO();
        List<ChuyenXe> listChuyenXe = chuyenXeDAO.getAll();
        thongKeChuyenXeAdapter.setData(listChuyenXe);
        setThongKeChuyenXeAdapter(thongKeChuyenXeAdapter);
    }

    public ThongKeChuyenXeAdapter getThongKeChuyenXeAdapter() {
        return thongKeChuyenXeAdapter;
    }

    public void setThongKeChuyenXeAdapter(ThongKeChuyenXeAdapter thongKeChuyenXeAdapter) {
        this.thongKeChuyenXeAdapter = thongKeChuyenXeAdapter;
    }
}
