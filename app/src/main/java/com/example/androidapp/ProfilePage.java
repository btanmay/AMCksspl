package com.example.androidapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ProfilePage extends AppCompatActivity
{
    private ImageView avatarIv;
    private TextView name1,address1,asset1,dc1,quantity1,tvDate,edDate;

    private String name,address,asset,company,quantity,date1,date2,image;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        image=getIntent().getStringExtra("image");
        name=getIntent().getStringExtra("name");
        address=getIntent().getStringExtra("address");
        asset=getIntent().getStringExtra("asset");
        company=getIntent().getStringExtra("company");
        quantity=getIntent().getStringExtra("quantity");
        date1=getIntent().getStringExtra("date1");
        date2=getIntent().getStringExtra("date2");

       // avatarIv=findViewById(R.id.avatarIv);
        name1=findViewById(R.id.name1);
        address1=findViewById(R.id.address1);
        asset1=findViewById(R.id.asset1);
        dc1=findViewById(R.id.dc1);
        quantity1=findViewById(R.id.quantity1);
        tvDate=findViewById(R.id.tvDate);
        edDate=findViewById(R.id.edDate);

       // Picasso.get().load(image).into(avatarIv);



        name1.setText(name);
        address1.setText(address);
        asset1.setText(asset);
        dc1.setText(company);
        quantity1.setText(quantity);
        tvDate.setText(date1);
        edDate.setText(date2);

    }


}

