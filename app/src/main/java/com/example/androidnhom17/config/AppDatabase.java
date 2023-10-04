package com.example.androidnhom17.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidnhom17.model.ChuyenXe;
import com.example.androidnhom17.model.DAO.ChuyenXeDAO;
import com.example.androidnhom17.model.DAO.DanhGiaDAO;
import com.example.androidnhom17.model.DAO.DatVeDAO;
import com.example.androidnhom17.model.DAO.LoaiXeDAO;
import com.example.androidnhom17.model.DAO.QuyenDao;
import com.example.androidnhom17.model.DAO.ThanhVienDAO;
import com.example.androidnhom17.model.DAO.TrangThaiDAO;
import com.example.androidnhom17.model.DanhGia;
import com.example.androidnhom17.model.DatVe;
import com.example.androidnhom17.model.LoaiXe;
import com.example.androidnhom17.model.Quyen;
import com.example.androidnhom17.model.ThanhVien;
import com.example.androidnhom17.model.TrangThai;

@Database(version = 1,
    entities = {
            ThanhVien.class,
            Quyen.class,
            ChuyenXe.class,
            LoaiXe.class,
            DanhGia.class,
            DatVe.class,
            TrangThai.class,
    }
    , exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ThanhVienDAO getThanhVienDAO();
    public abstract QuyenDao getQuyenDAO();
    public abstract ChuyenXeDAO getChuyenXeDAO();
    public abstract LoaiXeDAO getLoaiXeDAO();
    public abstract DanhGiaDAO getDanhGiaDAO();
    public abstract DatVeDAO getVeXeDAO();
    public abstract TrangThaiDAO getTrangThaiDAO();
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "doanandroid.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
