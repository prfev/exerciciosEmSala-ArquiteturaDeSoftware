package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btnMudarTela;
        btnMudarTela = findViewById(R.id.btnTo1Act);
        btnMudarTela.setOnClickListener(
                v -> {
                    Intent telaUm = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(telaUm);
                }
        );
        Intent intent = new Intent(this,MyIntentService.class);
        intent.putExtra("TELA","Terceira");
        startService(intent);

        List<ContactsService> contacts = ContactsViewHolder.getContacts(this);
        for (ContactsService contact: contacts){
            if (contacts.size() >= 3){
                contacts.get(2);
                Log.d("PRFEV","ID: "+ contact.getId() + ", Nome: "+ contact.getName());
            }
        }
    }
}