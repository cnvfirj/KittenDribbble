package com.kittendevelop.kittendribbble.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaActionSound;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.ui.help.ThreadTransformers;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        Uri uri = getActivity().getIntent().getData();
        if(uri==null) {
            String url = "https://dribbble.com/oauth/authorize?" +
                    "client_id=8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0&" +
                    "scope=public+upload";
            String register = "https://dribbble.com/oauth/signin?client_id=8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0";
            startActivityForResult(new Intent(Intent.ACTION_VIEW, Uri.parse(url)),111);
        }else {
            MASSAGE("get data "+uri.toString());
            MASSAGE("paranetr "+uri.getQueryParameter("code"));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MASSAGE("request "+requestCode);
        MASSAGE("result"+resultCode);
        Uri uri = data.getData();
        if(uri!=null)MASSAGE("data "+uri.toString());
    }
}