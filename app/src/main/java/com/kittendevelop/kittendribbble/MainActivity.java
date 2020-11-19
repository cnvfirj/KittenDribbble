package com.kittendevelop.kittendribbble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kittendevelop.kittendribbble.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private final String mAuthorize = "https://dribbble.com/oauth/authorize?" +
            "client_id=8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0&" +
            "scope=public+upload&" +
            "redirect_uri=kittencreativity://callback/application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

//        if(getIntent().getData()==null)startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mAuthorize)));
    }

}