package com.kittendevelop.kittendribbble.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.ui.register.CheckToken;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class RegisterActivity extends AppCompatActivity implements CheckToken {

    public final static int REQUEST_AUTH = 0;
    public final static String RESULT_TOKEN = "RegisterActivity result token";

    private RegisterPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        mPresenter = new RegisterPresenter(this);
        mPresenter.checkCallback(getIntent());
    }


    @Override
    public void gettingToken(String token) {
       Intent intent = new Intent();
       intent.putExtra(RESULT_TOKEN,token);
       setResult(Activity.RESULT_OK,intent);
       finish();
    }

    @Override
    public void followingLink(String link) {
       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }

    @Override
    public void startActivity() {

    }

    @Override
    public void showWaiting() {

    }

    @Override
    public void hideWaiting() {

    }

    public void onClick(View view) {
        mPresenter.clickView(view.getId());
    }

}