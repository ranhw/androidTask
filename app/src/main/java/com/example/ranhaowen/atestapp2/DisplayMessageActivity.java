package com.example.ranhaowen.atestapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String TAG = "[hello]DisplayMessage: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d (TAG, " onCreate in2");
        Toast.makeText(getApplicationContext(), "onCreat in2", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Log.d (TAG, " onCreate out2");
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }
}
