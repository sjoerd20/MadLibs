package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FillActivity extends AppCompatActivity {

    private Story retrievedStory;
    private int placeholderRemainingCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        // get intent from ChooseActivity
        Intent intent = getIntent();
        retrievedStory = (Story) intent.getSerializableExtra("chosen_story");

        // show how many placeholders are left to be filled in
        placeholderRemainingCount = retrievedStory.getPlaceholderRemainingCount();
        TextView amountFilled = findViewById(R.id.textViewAmountFilled);
        amountFilled.setText("Placeholders left: " + placeholderRemainingCount);
    }
}
