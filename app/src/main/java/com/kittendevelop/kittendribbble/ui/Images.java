package com.kittendevelop.kittendribbble.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kittendevelop.kittendribbble.ui.ui.main.ImagesFragment;

public class Images extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ImagesFragment.newInstance())
                    .commitNow();
        }
    }
}