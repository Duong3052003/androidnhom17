package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentVeDetailBinding;
import com.example.androidnhom17.model.DatVe;
import com.example.androidnhom17.viewmodel.DetailVeViewModel;

public class DetailVeFragment extends Fragment {

    FragmentVeDetailBinding fragmentVeDetailBinding;
    DetailVeViewModel veDetailViewModel = new DetailVeViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentVeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ve_detail, container, false);
        fragmentVeDetailBinding.setVeDetailViewModel(veDetailViewModel);

        Bundle bundle = getArguments();
        if (bundle != null){
            DatVe datVe = (DatVe) bundle.getSerializable("ve");

            veDetailViewModel.kiemTraNgayVe(fragmentVeDetailBinding.layoutLuotVe, datVe.getNgayGioVe());

            veDetailViewModel.setDetailVe(datVe, getContext());


            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, veDetailViewModel.listTrangThai(getContext()));

            fragmentVeDetailBinding.spnTrangThai.setAdapter(adapter);
            fragmentVeDetailBinding.spnTrangThai.setSelection(datVe.getIdTrangThai()-1);

            fragmentVeDetailBinding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    veDetailViewModel.updateTrangThai(datVe,getContext());
                }
            });
        }

        fragmentVeDetailBinding.spnTrangThai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                veDetailViewModel.setIdTrangThai(i + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Inflate the layout for this fragment
        return fragmentVeDetailBinding.getRoot();
    }

}