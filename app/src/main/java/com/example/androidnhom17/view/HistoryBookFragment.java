package com.example.androidnhom17.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidnhom17.R;
import com.example.androidnhom17.databinding.FragmentHistoryBookBinding;
import com.example.androidnhom17.viewmodel.HistoryBookViewModel;


public class HistoryBookFragment extends Fragment {

    FragmentHistoryBookBinding fragmentHistoryBookBinding;
    HistoryBookViewModel historyBookViewModel ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHistoryBookBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history_book, container, false);
        historyBookViewModel = new HistoryBookViewModel();
        fragmentHistoryBookBinding.setLichSuDatVeViewModel(historyBookViewModel);

        setAdapterForHistory();
        // Inflate the layout for this fragment
        return fragmentHistoryBookBinding.getRoot();
    }

    private void setAdapterForHistory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        fragmentHistoryBookBinding.rcvHistory.setLayoutManager(linearLayoutManager);
        historyBookViewModel.renderAdapter(getContext());
        fragmentHistoryBookBinding.rcvHistory.setAdapter(historyBookViewModel.getHistoryBookAdapter());
    }


}