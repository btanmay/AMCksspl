package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TicketActivity extends AppCompatActivity {

    EditText Fname,Address,Phno,Des;
    CheckBox Deskop,Laptop,Printer,NtDevice;
    Button Submit;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        reference = FirebaseDatabase.getInstance().getReference().child("ticket");

        Fname=findViewById(R.id.name);
        Address=findViewById(R.id.address);
        Phno=findViewById(R.id.txt_number);
        Deskop=(CheckBox) findViewById(R.id.DS);
        Laptop=(CheckBox)findViewById(R.id.LP);
        Printer=(CheckBox)findViewById(R.id.PT);
        NtDevice=(CheckBox)findViewById(R.id.ND);
        Des=findViewById(R.id.des);
        Submit=findViewById(R.id.btn_submit);



        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addTicket1();
                Intent intent=new Intent(TicketActivity.this,TicketRetriveActivity.class);
                startActivity(intent);


            }
        });
    }

    private void addTicket1()
    {
        String Fname1= Fname.getText().toString().trim();
        String Address1= Address.getText().toString().trim();
        String Phno1= Phno.getText().toString().trim();
        String Des1= Des.getText().toString().trim();

        if(!TextUtils.isEmpty(Fname1)&& !TextUtils.isEmpty(Address1)&& !TextUtils.isEmpty(Phno1)&& !TextUtils.isEmpty(Des1))
        {


            String id =    reference.push().getKey();
            Ticket2 ticket1 = new Ticket2(Fname1,Address1,Phno1,Des1);
            reference.child(id).setValue(ticket1);
            Toast.makeText(this,"Ticket Added",Toast.LENGTH_SHORT).show();




        }
        else
        {
            Toast.makeText(this,"You Should enter the Information",Toast.LENGTH_SHORT).show();

        }

    }

}