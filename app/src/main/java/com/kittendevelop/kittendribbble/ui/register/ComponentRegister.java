package com.kittendevelop.kittendribbble.ui.register;


import androidx.fragment.app.Fragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ComponentRegister {
    RegisterDialog dialog();
    RegisterPresenter presenter();
}
