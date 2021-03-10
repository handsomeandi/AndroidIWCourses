package com.example.coursehomeworktwo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public static final String ACTION_TESTING = "action_testing";
    public static final String SERVICE_EXTRA = "serviceExtra";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataFromIntent;
        if(intent != null){
            dataFromIntent = intent.getStringExtra(SERVICE_EXTRA);
            Intent broadcastIntent = new Intent(ACTION_TESTING);
            broadcastIntent.putExtra(SERVICE_EXTRA, dataFromIntent);
            sendBroadcast(broadcastIntent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}