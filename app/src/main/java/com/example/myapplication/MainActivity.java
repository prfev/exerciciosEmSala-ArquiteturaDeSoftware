package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMudarTela;
        btnMudarTela = findViewById(R.id.btnTo2Act);

        btnMudarTela.setOnClickListener(
                v -> {
                    Intent telaDois = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(telaDois);
                }
        );
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TELA", "Primeira");
        startService(intent);

        List<ContactsService> contacts = ContactsViewHolder.getContacts(this);
        for (ContactsService contact : contacts) {
            Log.d("PRFEV", "ID: " + contact.getId() + ", Nome: " + contact.getName());
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter );
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (receiver != null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }
    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            Log.d("PRFEV", "Status do wi-fi mudou");
        }
    }
}