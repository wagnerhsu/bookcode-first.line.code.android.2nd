package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getStringExtra("lachesis_barcode_value_notice_broadcast_data_string");
        Toast.makeText(context, "received local broadcast: " + action, Toast.LENGTH_SHORT).show();
    }

}
