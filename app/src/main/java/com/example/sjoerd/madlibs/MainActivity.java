package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.buttonPlay);
        playButton.setOnClickListener(new OnPlayButtonClickListener());
    }

    // go to ChooseActivity if playButton is clicked.
    private class OnPlayButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
            startActivity(intent);
        }
    }
}
