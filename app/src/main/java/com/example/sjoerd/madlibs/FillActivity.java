package com.example.sjoerd.madlibs;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        // get first placeholder and if not empty, place it as a hint
        String placeholder = retrievedStory.getNextPlaceholder();
        if (!placeholder.equals("")) {
            TextInputEditText textInput = findViewById(R.id.textInput);
            textInput.setHint(placeholder);
        }

        // implement okButton listener
        Button okButton = (Button) findViewById(R.id.buttonOk);
        okButton.setOnClickListener(new OnButtonClickListener());
    }

    // this class stores the filled placeholder and get the next placeholder.
    // If the last placeholder is reached, it starts StoryActivity
    private class OnButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            TextInputEditText textInput = (TextInputEditText) findViewById(R.id.textInput);
            Editable filledInPlaceholderEditable = textInput.getText();
            if (filledInPlaceholderEditable != null) {
                String filledInPlaceholder = filledInPlaceholderEditable.toString();

                // check if something is filled in. If not continue to listen for new events
                if (filledInPlaceholder.length() != 0) {
                    retrievedStory.fillInPlaceholder(filledInPlaceholder);

                    // get next placeholder and if not empty, place it as a hint
                    String placeholder = retrievedStory.getNextPlaceholder();
                    if (!placeholder.equals("")) {
                        textInput.setHint(placeholder);

                        // show how many placeholders are left to be filled in
                        placeholderRemainingCount = retrievedStory.getPlaceholderRemainingCount();
                        TextView amountFilled = findViewById(R.id.textViewAmountFilled);
                        amountFilled.setText("Placeholders left: " + placeholderRemainingCount);

                        // empty text field
                        textInput.setText("");
                    }

                    // if placeholder empty, start next activity
                    else {
                        Intent intent = new Intent(FillActivity.this,
                                StoryActivity.class);
                        intent.putExtra("chosen_story", retrievedStory);
                        startActivity(intent);
                    }
                }
            }
        }
    }
}
