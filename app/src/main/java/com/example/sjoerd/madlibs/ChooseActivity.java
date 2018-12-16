package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;

public class ChooseActivity extends AppCompatActivity {

    // all story files
    private int storyFiles[] = {R.raw.madlib0_simple, R.raw.madlib1_tarzan,
                                R.raw.madlib2_university, R.raw.madlib3_clothes,
                                R.raw.madlib4_dance};

    private String storyNames[] = {"Simple", "Tarzan", "University", "Clothes", "Dance"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        storyNames);
        ListView list = findViewById(R.id._storyList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnStoryClickListener());
    }

    private class OnStoryClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            int storyId = storyFiles[i];
            InputStream inputStream = getResources().openRawResource(storyId);
            Story story = new Story(inputStream);

            // pass story to new activity called FillActivity
            Intent intent = new Intent(ChooseActivity.this, FillActivity.class);
            intent.putExtra("chosen_story", story);
            startActivity(intent);
        }
    }
}
