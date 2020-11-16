package com.kittendevelop.kittendribbble.ui.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.kittendevelop.kittendribbble.R;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterPresenter {

    private final String mDribbble = "https://dribbble.com";
    private final String mSignUp = "https://dribbble.com/signup/new";
    private final String mLinkApp = "https://dribbble.com/account/applications/59798";

    private final String mDribbbleCallbackURL = "kittencreativity://callback";
    private final String mClientID = "8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0";
    private final String mClientSecret = "4fc3c445569dbfe65998c470e88cc05fcd4872079ca1f2191eefec133895224e";



    private final String mAuthorize = "https://dribbble.com/oauth/authorize?" +
            "client_id=8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0&" +
            "scope=public+upload";

    private final CheckToken mCheckToken;

    public RegisterPresenter(CheckToken mCheckToken) {
        this.mCheckToken = mCheckToken;
    }

    @SuppressLint("NonConstantResourceId")
    public void clickView(int id){
        switch (id){
            case R.id.register_logo_dribbble:
            case R.id.register_mark_dribbble:
                mCheckToken.followingLink(mDribbble);
                break;
            case R.id.register_signIn:
                mCheckToken.followingLink(mAuthorize);
                break;
            case R.id.register_signUp:
                mCheckToken.followingLink(mSignUp);
                break;
        }
    }

    public void checkCallback(Intent intent){
        if(intent!=null){
            Uri uri = intent.getData();
            if(uri!=null) {
                if(uri.getScheme().equals("kittencreativity")&&uri.getHost().equals("callback")){
                    String code = uri.getQueryParameter("code");
                    MASSAGE("request code");


                }



            }
        }
    }

    private void authorize(){

    }
}
