package com.kittendevelop.kittendribbble.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.ui.register.RegisterDialog;

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
//        mViewModel = new ViewModelProvider(this, new ViewModelFactory(new MainViewModel(getActivity().getApplication())))
//                        .get(MainViewModel.class);
    }


    @Override
    public void onResume() {
        super.onResume();
        Uri uri = getActivity().getIntent().getData();
        if(uri!=null){
            extractData(uri);
        }else RegisterDialog.show(getChildFragmentManager());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void extractData(Uri uri){
        MASSAGE("uri "+uri.toString());
            requestToken(uri.getQueryParameter("code"));
    }

    private void requestToken(String code){
        MASSAGE("code "+code);
    }


}