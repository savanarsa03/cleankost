package com.example.cleankost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class beranda extends AppCompatActivity {
    Button pesan1, pesan2, pesan3, pesan4, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        pesan1 = findViewById(R.id.b_buy1);
        pesan2 = findViewById(R.id.b_buy2);
        pesan3 = findViewById(R.id.b_buy3);
        pesan4 = findViewById(R.id.b_buy4);
        data = findViewById(R.id.data);

        data.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), tampilancleaning.class);
            startActivity(intent);

        });
        pesan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Order_Cleaning.class);
                startActivity(i);
            }
        });

        pesan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Order_Cleaning.class);
                startActivity(i);
            }
        });

        pesan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Order_Cleaning.class);
                startActivity(i);
            }
        });

        pesan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Order_Cleaning.class);
                startActivity(i);
            }
        });
    }
}
