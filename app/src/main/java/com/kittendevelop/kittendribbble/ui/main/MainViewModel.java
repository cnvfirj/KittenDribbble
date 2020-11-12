package com.kittendevelop.kittendribbble.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final String mSignUp = "https://dribbble.com/signup/new";
    private final String mLinkApp = "https://dribbble.com/account/applications/59798";

    private final String mDribbbleCallbackURL = "kittencreativity://callback";
    private final String mClientID = "8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0";
    private final String mClientSecret = "4fc3c445569dbfe65998c470e88cc05fcd4872079ca1f2191eefec133895224e";

    private final String mAuthorize = "https://dribbble.com/oauth/authorize";

    public String getLinkApp() {
        return mLinkApp;
    }

    public String getDribbbleCallbackURL() {
        return mDribbbleCallbackURL;
    }

    public String getClientID() {
        return mClientID;
    }

    public String getClientSecret() {
        return mClientSecret;
    }

    public String getAuthorize() {
        return mAuthorize;
    }

    public String getmSignUp() {
        return mSignUp;
    }
}