package com.example.androidnhom17.view;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentAddThanhVienBinding;
import com.example.androidnhom17.viewmodel.AddThanhVienViewModel;


public class AddThanhVienFragment extends Fragment {
    FragmentAddThanhVienBinding fragmentAddThanhVienBinding;
    AddThanhVienViewModel addThanhVienViewModel = new AddThanhVienViewModel();
    private ActivityResultLauncher<Intent> imagePickerLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentAddThanhVienBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_thanh_vien, container, false);
        fragmentAddThanhVienBinding.setAddThanhVienViewModel(addThanhVienViewModel);

        fragmentAddThanhVienBinding.edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThanhVienViewModel.showDatePickerDialog(getContext());
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, addThanhVienViewModel.getListTenQuyen(getContext()));

        fragmentAddThanhVienBinding.spnerTenQuyen.setAdapter(adapter);

        fragmentAddThanhVienBinding.spnerTenQuyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                addThanhVienViewModel.getIdQuyenThanhVien((String) adapterView.getItemAtPosition(i), getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fragmentAddThanhVienBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThanhVienViewModel.handleAddThanhVien(getContext());
            }
        });

        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedImageUri = result.getData().getData();
                        addThanhVienViewModel.uploadImageToFireBase(selectedImageUri, getContext());
                    }
                }
        );

        fragmentAddThanhVienBinding.edtAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imagePickerLauncher.launch(intent);
            }
        });

        return fragmentAddThanhVienBinding.getRoot();
    }

}