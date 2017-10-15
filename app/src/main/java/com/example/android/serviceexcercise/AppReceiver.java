package com.example.android.serviceexcercise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SPlayer on 08/10/2017.
 */

public class AppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String receivedData = intent.getExtras().getString("DATA");
        Toast.makeText(context,receivedData,Toast.LENGTH_SHORT).show();
    }
}
