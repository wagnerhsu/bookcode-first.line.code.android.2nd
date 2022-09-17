package com.example.activitylifecycletest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);
    }
}
