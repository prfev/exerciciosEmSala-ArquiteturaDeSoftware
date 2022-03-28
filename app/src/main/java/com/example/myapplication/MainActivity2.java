package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnMudarTela;

        btnMudarTela = findViewById(R.id.btnTo3Act);

        btnMudarTela.setOnClickListener(
                v -> {
                    Intent telaTres = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(telaTres);
                }
        );

        Intent intent2 = new Intent(this,MyIntentService.class);
        intent2.putExtra("TELA","Segunda");
        startService(intent2);

        List<ContactsService> contacts = ContactsViewHolder.getContacts(this);
        for (ContactsService contact: contacts){
            if (contacts.size() >= 2){
                contacts.get(1);
                Log.d("PRFEV","ID: "+ contact.getId() + ", Nome: "+ contact.getName());
            }
        }
    }
}