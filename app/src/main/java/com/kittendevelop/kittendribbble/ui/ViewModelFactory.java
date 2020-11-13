package com.kittendevelop.kittendribbble.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kittendevelop.kittendribbble.ui.main.MainViewModel;
import com.kittendevelop.kittendribbble.ui.register.RegisterViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ViewModel mAndroidViewModel;

    public ViewModelFactory(ViewModel viewModel) {
        mAndroidViewModel = viewModel;
    }

    @NonNull
    @Override
    public <E extends ViewModel> E create(@NonNull Class<E> modelClass) {
        return  (E)mAndroidViewModel;
    }
}
