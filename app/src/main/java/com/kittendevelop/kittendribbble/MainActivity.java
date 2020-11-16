package com.kittendevelop.kittendribbble;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.kittendevelop.kittendribbble.ui.main.MainFragment;
import com.kittendevelop.kittendribbble.ui.register.RegisterActivity;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

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

    }

}