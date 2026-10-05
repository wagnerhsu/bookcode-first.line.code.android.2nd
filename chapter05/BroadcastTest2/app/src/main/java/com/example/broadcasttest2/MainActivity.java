package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String BAR_READ_ACTION = "SYSTEM_BAR_READ";
    public BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReceiver();
        IntentFilter filter = new IntentFilter(BAR_READ_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initReceiver() {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals(BAR_READ_ACTION)) {
                    String BAR_value = intent.getStringExtra("BAR_VALUE");
                    Log.d("MainActivity", "Received BAR_VALUE: " + BAR_value);
                    Toast.makeText(context, "BAR_VALUE: " + BAR_value, Toast.LENGTH_LONG).show(); // Handle broadcast
                }
            }
        };

    }
}
