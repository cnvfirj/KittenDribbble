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

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.databinding.RegisterDialogBinding;

import javax.inject.Inject;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterDialog extends DialogFragment implements CheckToken{


    private RegisterPresenter mPresenter;


    @Inject
    public RegisterDialog() {
        MASSAGE("RegisterDialog init dialog");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return create(inflater);
    }

    @Override
    public void followingLink(String link) {
         startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
         dismiss();
    }

    private View create(LayoutInflater inflater){
        mPresenter = DaggerComponentRegister.create().presenter();
        mPresenter.takeView(this);
        View v = inflater.inflate(R.layout.register_dialog,null);
        RegisterDialogBinding binding = DataBindingUtil.bind(v);
        binding.setDialog(this);
        return v;
    }


    public void click(View view){
        mPresenter.clickView(view.getId());
    }
}
