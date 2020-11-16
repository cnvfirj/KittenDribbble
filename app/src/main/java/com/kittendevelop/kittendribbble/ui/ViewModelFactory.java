package com.kittendevelop.kittendribbble.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


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
