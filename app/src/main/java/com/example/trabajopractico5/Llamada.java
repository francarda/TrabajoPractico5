package com.example.trabajopractico5;

import static android.net.wifi.WifiManager.EXTRA_WIFI_STATE;
import static android.net.wifi.WifiManager.WIFI_STATE_CHANGED_ACTION;
import static android.net.wifi.WifiManager.WIFI_STATE_DISABLED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Llamada extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getBooleanExtra("connected", false)) {
            Toast.makeText(context, "Lamando al 2664553747", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Intent.ACTION_CALL);
            in.setData(Uri.parse("tel:2664553747"));
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(in);
            //context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:2664553747")));
        }
    }
}
