package com.kittendevelop.kittendribbble.ui.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.kittendevelop.kittendribbble.R;

import javax.inject.Inject;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterPresenter {


    private CheckToken mView;
    private RegisterModel mModel;

    @Inject
    public RegisterPresenter(RegisterModel model) {
        MASSAGE("RegisterPresenter init register presenter");
        mModel = model;
    }

    public void takeView(CheckToken mView){
        this.mView = mView;
    }

    @SuppressLint("NonConstantResourceId")
    public void clickView(int id){
        switch (id){
            case R.id.register_logo_dribbble:
            case R.id.register_mark_dribbble:
                mView.followingLink(mModel.getDribbble());
                break;
            case R.id.register_signIn:
                mView.followingLink(mModel.getAuthorize());
                break;
            case R.id.register_signUp:
                mView.followingLink(mModel.getSignUp());
                break;
        }
    }

}
