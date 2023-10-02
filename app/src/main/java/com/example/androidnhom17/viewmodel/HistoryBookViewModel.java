package com.example.androidnhom17.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.androidnhom17.adapter.HistoryBookAdapter;
import com.example.androidnhom17.config.AppDatabase;
import com.example.androidnhom17.config.DataLocalManager;
import com.example.androidnhom17.model.DAO.DatVeDAO;
import com.example.androidnhom17.model.DAO.ThanhVienDAO;
import com.example.androidnhom17.model.DatVe;
import com.example.androidnhom17.model.ThanhVien;

import java.util.List;

public class HistoryBookViewModel extends BaseObservable {
    private HistoryBookAdapter historyBookAdapter;

    public void renderAdapter(Context context){
        historyBookAdapter = new HistoryBookAdapter(context);
        DatVeDAO datVeDAO = AppDatabase.getInstance(context).getVeXeDAO();
        ThanhVienDAO thanhVienDAO= AppDatabase.getInstance(context).getThanhVienDAO();
        ThanhVien thanhVien = thanhVienDAO.getThanhVienByUserName(DataLocalManager.getNameUser());
        List<DatVe> datVes = datVeDAO.getVeXeById(thanhVien.getId());

        historyBookAdapter.setData(datVes);
        setHistoryBookAdapter(historyBookAdapter);
    }

    public HistoryBookAdapter getHistoryBookAdapter() {
        return historyBookAdapter;
    }

    public void setHistoryBookAdapter(HistoryBookAdapter historyBookAdapter) {
        this.historyBookAdapter = historyBookAdapter;
    }
}
