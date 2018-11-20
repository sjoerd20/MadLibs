package com.example.sjoerd.madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;

public class ChooseActivity extends AppCompatActivity {

    // all story files
    private int storyFiles[] = {R.raw.madlib0_simple, R.raw.madlib1_tarzan,
                                R.raw.madlib2_university, R.raw.madlib3_clothes,
                                R.raw.madlib4_dance};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    // TODO implement OnStoryClickListener
    // class OnStoryClickListener implements ... {
        // TODO index = get index
        // InputStream is = getResources().openRawResource(storyFiles[index]);


    }
}
