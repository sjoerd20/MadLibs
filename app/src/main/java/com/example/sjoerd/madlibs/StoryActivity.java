package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    private Story retrievedStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // get intent from ChooseActivity
        Intent intent = getIntent();
        retrievedStory = (Story) intent.getSerializableExtra("chosen_story");

        TextView textViewStory = (TextView) findViewById(R.id.textViewStory);
        textViewStory.setText(retrievedStory.toString());
    }

    // back navigation to MainActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StoryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
