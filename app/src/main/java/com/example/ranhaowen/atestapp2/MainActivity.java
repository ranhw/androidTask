package com.example.ranhaowen.atestapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String TAG = "[hello]MainActivity: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, " onCreate in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreat in", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " onCreate out");
    }

    public void sendMessage(View view) {
        Log.d(TAG, " sendMessage in");
        Toast.makeText(getApplicationContext(), "sendMessage in", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "sendMessage out", Toast.LENGTH_SHORT).show();
        Log.d(TAG, " sendMessage out");
    }

    public void displayDevices(View view) {
        Log.d(TAG, " Devices");
        Toast.makeText(getApplicationContext(), "Devices", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OutputPhoneMessage.class);
        startActivity(intent);
        Log.d (TAG, " sendMessage out");
    }
}
