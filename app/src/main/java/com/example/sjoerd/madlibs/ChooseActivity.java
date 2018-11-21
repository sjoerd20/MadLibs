package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class ChooseActivity extends AppCompatActivity {

    // all story files
    private int storyFiles[] = {R.raw.madlib0_simple, R.raw.madlib1_tarzan,
                                R.raw.madlib2_university, R.raw.madlib3_clothes,
                                R.raw.madlib4_dance};

    private String storyNames[] = {"madlib0_simple", "madlib1_tarzan", "madlib2_university",
                                "madlib3_clothes", "madlib4_dance"};

    private int buttons[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                                R.id.button4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // set text and OnClickListener for every button
        for (int i = 0; i < storyFiles.length; i++) {
            Button button = findViewById(buttons[i]);
            button.setText(storyNames[i]);
            button.setOnClickListener(new OnStoryClickListener());
        }
    }

    private class OnStoryClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int storyId = 0;
            int buttonId = view.getId();
            for (int i = 0; i < buttons.length; i++) {
                if (buttonId == buttons[i]) {
                    storyId = storyFiles[i];
                }
            }
            // construct the selected story
            InputStream inputStream = getResources().openRawResource(storyId);
            Story story = new Story(inputStream);

            // pass story to new activity called FillActivity
            Intent intent = new Intent(ChooseActivity.this, FillActivity.class);
            intent.putExtra("chosen_story", story);
            startActivity(intent);
        }
    }
}
