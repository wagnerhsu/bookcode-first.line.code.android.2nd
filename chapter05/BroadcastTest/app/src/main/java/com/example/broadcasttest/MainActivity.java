package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    final String actionName = "lachesis_barcode_value_notice_broadcast";
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
        localBroadcastManager = LocalBroadcastManager.getInstance(this); // 获取实例

        Button button = (Button) findViewById(R.id.btnSendBarcodeBroadcast);
        button.setOnClickListener(v -> {

            Intent intent = new Intent(actionName);
            intent.putExtra("lachesis_barcode_value_notice_broadcast_data_string", "12345");

            sendBroadcast(intent);
        });

        Button btnSendLocalBroadcast = (Button) findViewById(R.id.btnSendLocalBroadcast);
        btnSendLocalBroadcast.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
            localBroadcastManager.sendBroadcast(intent); // 发送本地广播
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction(actionName);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter); // 注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }

    }


}
