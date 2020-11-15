package com.kittendevelop.kittendribbble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import com.kittendevelop.kittendribbble.ui.main.MainFragment;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class MainActivity extends AppCompatActivity {

    public static Application a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("kittencreativity://callback")));
        MASSAGE("create");
        startActivityForResult(new Intent(this, RegisterActivity.class),100);
        a = getApplication();
    }


}