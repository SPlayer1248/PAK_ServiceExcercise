package com.example.android.serviceexcercise;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.registerReceiver(new AppReceiver(), new IntentFilter("CUSTOM_ACTION"));

        findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Press start service");
                startService(new Intent(MainActivity.this, MainService.class));
            }
        });

        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Press stop service");
                stopService(new Intent(MainActivity.this, MainService.class));
            }
        });

        findViewById(R.id.btnBindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Press bind service");
                Intent i = new Intent(MainActivity.this, MainService.class);
                bindService(i, MainActivity.this, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btnUnBindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Press unbind service");
                unbindService(MainActivity.this);
            }
        });

        findViewById(R.id.btnBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Press send broadcast");
                Intent i = new Intent("CUSTOM_ACTION");
                i.putExtra("DATA", "Really?");
                sendBroadcast(new Intent(i));
            }
        });

        findViewById(R.id.btnFinish).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Toast.makeText(this, "Service onServiceConnected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Toast.makeText(this, "Service onServiceDisconnected", Toast.LENGTH_SHORT).show();
    }


}
