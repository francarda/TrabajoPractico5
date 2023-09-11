package com.example.trabajopractico5;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private Llamada lla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrarBroadCast();
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }

    }
    private void registrarBroadCast(){
    this.lla=new Llamada();
    registerReceiver(this.lla, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.lla);
    }
}