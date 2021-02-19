package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AndroidMain extends AppCompatActivity
{
    TextView Company;
    TextView Admin;
    TextView Technician;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_main);

        Admin = findViewById(R.id.txtAdmin);
        Company = findViewById(R.id.Company);
        Technician = findViewById(R.id.txtTech);
        context = this;


        Admin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, SignInActivity.class);
                startActivity(intent);
            }

        });


        Company.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, AndroidMain1.class);
                startActivity(intent);
            }

        });

        Technician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,TechnicianActivity.class);
                startActivity(intent);
            }
        });

    }
}