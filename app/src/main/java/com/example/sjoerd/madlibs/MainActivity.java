package com.example.sjoerd.madlibs;

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

    private class OnPlayButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // TODO go to next activity with intent
        }
    }

    // starts a MadLib game if the play button is clicked
    public void playButtonClicked(android.view.View sender) {
        Button b = (Button) sender;
        b.setText("Clicked!");
    }
}
