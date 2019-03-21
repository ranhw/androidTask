package com.example.ranhaowen.atestapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String TAG = "[hello]MainActivity: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d (TAG, " onCreate in");
        Toast.makeText(getApplicationContext(), "onCreat in", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreat out", Toast.LENGTH_SHORT).show();
        Log.d (TAG, " onCreate out");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void sendMessage(View view) {
        Log.d (TAG, " sendMessage in");
        Toast.makeText(getApplicationContext(), "sendMessage in", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "sendMessage out", Toast.LENGTH_SHORT).show();
        Log.d (TAG, " sendMessage out");
    }
}
