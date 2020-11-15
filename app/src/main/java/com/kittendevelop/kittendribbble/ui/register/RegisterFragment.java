package com.kittendevelop.kittendribbble.ui.register;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaActionSound;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.ui.ViewModelFactory;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;

    private TextView mTextPreview;
    private ImageView mLogo;
    private ImageView mMark;
    private Button mSignIn;
    private Button mSignUp;

    private Observer<String> observer;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        getLifecycle().addObserver(mViewModel);
        mTextPreview = getView().findViewById(R.id.register_preview);
        mLogo = getView().findViewById(R.id.register_logo_dribbble);
        mMark = getView().findViewById(R.id.register_mark_dribbble);
        mSignIn = getView().findViewById(R.id.register_signIn);
        mSignUp = getView().findViewById(R.id.register_signUp);

//        applyObserve();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mViewModel = new ViewModelProvider(this, new ViewModelFactory(new RegisterViewModel(getActivity().getApplication()))).get(RegisterViewModel.class);
//        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

    }



    private void applyObserve(){
         mViewModel.getPreviewMassage().observe(this, new Observer<String>() {
             @Override
             public void onChanged(String s) {
                 mTextPreview.setText(s);
             }
         });
         mViewModel.getLogo().observe(this, new Observer<Drawable>() {
             @Override
             public void onChanged(Drawable drawable) {
                 mLogo.setImageDrawable(drawable);
             }
         });

         mViewModel.getMark().observe(this, new Observer<Drawable>() {
             @Override
             public void onChanged(Drawable drawable) {
                 mMark.setImageDrawable(drawable);
             }
         });

         observer = new Observer<String>() {
             @Override
             public void onChanged(String s) {
                 MASSAGE("observe "+s);
                 mSignIn.setText(s);
             }
         };
         mViewModel.getSignIn().observe(this, observer);

         mViewModel.getSignUp().observe(this, new Observer<String>() {
             @Override
             public void onChanged(String s) {
                 mSignUp.setText(s);
             }
         });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearObserve();
    }

    private void clearObserve(){
//        mViewModel.getSignIn().removeObserver(observer);
    }
}