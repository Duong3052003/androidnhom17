package com.example.androidnhom17.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.androidnhom17.adapter.ThongKeNguoiDungAdapter;
import com.example.androidnhom17.config.AppDatabase;
import com.example.androidnhom17.model.DAO.ThanhVienDAO;
import com.example.androidnhom17.model.ThanhVien;

import java.util.List;

public class ThongKeNguoiDungViewModel extends BaseObservable {
    private ThongKeNguoiDungAdapter thongKeNguoiDungAdapter;

    public void renderAdapter(Context context){
        thongKeNguoiDungAdapter = new ThongKeNguoiDungAdapter(context);
        ThanhVienDAO thanhVienDAO = AppDatabase.getInstance(context).getThanhVienDAO();
        List<ThanhVien> list = thanhVienDAO.getThanhVienByIdQuyen(3);
        thongKeNguoiDungAdapter.setData(list);
        setThongKeNguoiDungAdapter(thongKeNguoiDungAdapter);

    }

    public ThongKeNguoiDungAdapter getThongKeNguoiDungAdapter() {
        return thongKeNguoiDungAdapter;
    }

    public void setThongKeNguoiDungAdapter(ThongKeNguoiDungAdapter thongKeNguoiDungAdapter) {
        this.thongKeNguoiDungAdapter = thongKeNguoiDungAdapter;
    }
}
