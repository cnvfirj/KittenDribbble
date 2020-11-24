package com.kittendevelop.kittendribbble.ui.register;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.databinding.RegisterDialogBinding;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterDialog extends DialogFragment implements CheckToken{


    private RegisterPresenter mPresenter;

    @Inject
    public RegisterDialog(RegisterPresenter presenter) {
        MASSAGE("RegisterDialog init register dialog");
        mPresenter = presenter;
//        mPresenter.takeView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter.takeView(this);
        View v = inflater.inflate(R.layout.register_dialog,null);
        RegisterDialogBinding binding = DataBindingUtil.bind(v);
        binding.setDialog(this);
        return v;
    }

    @Override
    public void followingLink(String link) {
         startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
         dismiss();
    }


    public void click(View view){
        mPresenter.clickView(view.getId());
    }
}
