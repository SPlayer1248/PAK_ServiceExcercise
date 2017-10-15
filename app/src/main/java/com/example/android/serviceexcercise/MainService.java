package com.example.android.serviceexcercise;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SPlayer on 08/10/2017.
 */

public class MainService extends Service {

    public static String TAG = MainService.class.getSimpleName();

    public class MainBinder extends Binder {
        MainService getService(){
            return MainService.this;
        }
    }

    IBinder mIBinder = new MainBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        Toast.makeText(this, "Service onBound", Toast.LENGTH_SHORT).show();
        return mIBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnBind");
        Toast.makeText(this, "Service onUnBind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        Toast.makeText(this, "Service onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        Toast.makeText(this, "Service onStartCommand", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        Toast.makeText(this, "Service onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
