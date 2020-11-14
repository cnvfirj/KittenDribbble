package com.kittendevelop.kittendribbble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.kittendevelop.kittendribbble.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


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
        startActivityForResult(new Intent(this,RegisterActivity.class),100);
    }


}