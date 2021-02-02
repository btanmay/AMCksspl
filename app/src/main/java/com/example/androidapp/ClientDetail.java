package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ClientDetail extends AppCompatActivity {

    TextView name,address,asset,company,quantity,date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        name = (TextView)findViewById(R.id.name1);
        address = (TextView)findViewById(R.id.address1);
        asset = (TextView)findViewById(R.id.asset1);
        company = (TextView)findViewById(R.id.company1);
        quantity = (TextView)findViewById(R.id.quantity1);
        date1 = (TextView)findViewById(R.id.date1);
        date2 = (TextView)findViewById(R.id.date2);

        Intent intent = getIntent();
        String iname = intent.getStringExtra("name");
        String iaddress = intent.getStringExtra("address");
        String icompany = intent.getStringExtra("company");
        String iasset = intent.getStringExtra("asset");
        String idate1 = intent.getStringExtra("date1");
        String idate2 = intent.getStringExtra("date2");
        String iquantity = intent.getStringExtra("quantity");

        name.setText(iname);
        address.setText(iaddress);
        asset.setText(iasset);
        company.setText(icompany);
        quantity.setText(iquantity);
        date2.setText(idate2);
        date1.setText(idate1);


    }
}