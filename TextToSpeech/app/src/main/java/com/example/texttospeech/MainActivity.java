package com.example.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {

                textToSpeech.setLanguage(Locale.ENGLISH);


                textToSpeech.setPitch(1.2f);
                textToSpeech.setSpeechRate(0.8f);
            }
        });

        button.setOnClickListener(view -> {
            String inputText = editText.getText().toString();
            textToSpeech.speak(inputText, TextToSpeech.QUEUE_FLUSH, null, "utteranceId1");
        });
    }
}
