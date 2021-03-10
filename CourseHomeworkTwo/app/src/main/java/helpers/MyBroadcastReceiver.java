package helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private MyBroadcastListener listener;
    private static final String SERVICE_EXTRA = "serviceExtra";

    public  MyBroadcastReceiver(MyBroadcastListener listener){
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.updateUI(intent.getStringExtra(SERVICE_EXTRA));
    }

}
