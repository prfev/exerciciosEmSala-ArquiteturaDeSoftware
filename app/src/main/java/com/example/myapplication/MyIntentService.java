package com.example.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String name = intent.getStringExtra("TELA");
            Toast.makeText(this, "Esta tela é a: " + name, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("PRFEV", "OnDestroy do IntentService");
    }
}