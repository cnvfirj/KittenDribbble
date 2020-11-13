package com.kittendevelop.kittendribbble.ui.register;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.kittendevelop.kittendribbble.R;

import org.jetbrains.annotations.Contract;

import static androidx.lifecycle.Lifecycle.Event.ON_ANY;
import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;


public class RegisterViewModel extends AndroidViewModel {

    private final String mRegister = "https://dribbble.com/signup/new";
    private final String mAuthorize = "https://dribbble.com/oauth/authorize";
    private final String mLink = "https://dribbble.com";
    private final String mPrivatePolicy = "https://dribbble.com/privacy";
    private final String mTermsService = "https://dribbble.com/terms";
    private final String mCommunityGuidelines = "https://dribbble.com/guidelines";



    private final String mDribbbleCallbackURL = "kittencreativity://callback";
    private final String mID = "8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0";
    private final String mSecret = "4fc3c445569dbfe65998c470e88cc05fcd4872079ca1f2191eefec133895224e";

    private MutableLiveData<String> mPreviewMassage = new MutableLiveData<>();
    private MutableLiveData<Drawable> mMark = new MutableLiveData<>();
    private MutableLiveData<Drawable> mLogo = new MutableLiveData<>();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        initVars();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initVars(){
        mPreviewMassage.setValue(getApplication().getString(R.string.register_preview));
        mMark.setValue(getApplication().getDrawable(R.drawable.ic_dribbble_ball_mark));
        mLogo.setValue(getApplication().getDrawable(R.drawable.ic_dribbble_logo));
    }

//    @OnLifecycleEvent(ON_ANY)
//    private void s(LifecycleOwner source, Lifecycle.Event event){
//        MASSAGE("RegisterViewModel "+event.name());
//    }


    public MutableLiveData<String> getPreviewMassage() {
        return mPreviewMassage;
    }

    public MutableLiveData<Drawable> getMark() {
        return mMark;
    }

    public MutableLiveData<Drawable> getLogo() {
        return mLogo;
    }
}
