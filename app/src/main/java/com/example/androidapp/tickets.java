package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tickets extends AppCompatActivity {

    EditText Name,Address,Mobileno,Des,email;
    Spinner Asset,Priority;
    Button Submit;

    DatabaseReference ticketreference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);


        ticketreference= FirebaseDatabase.getInstance().getReference().child("tickets");
        Name =(EditText)findViewById(R.id.name);
        Address =(EditText)findViewById(R.id.address);
        Mobileno =(EditText) findViewById(R.id.txt_number);
        email=(EditText) findViewById(R.id.mail);
        Asset=(Spinner)findViewById(R.id.asset);
        Priority=(Spinner)findViewById(R.id.priority);
        Des=(EditText)findViewById(R.id.des);
        Submit=(Button)findViewById(R.id.btn_submit);

        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addClient();
            }



        });
    }


    private String sendMail()
    {
        String name= Name.getText().toString().trim();
        String address= Address.getText().toString().trim();
        String mobileno=  Mobileno.getText().toString();
        String asset=  Asset.getSelectedItem().toString();
        String priority = Priority.getSelectedItem().toString();
        String mail = email.getText().toString().trim();
        String description= Des.getText().toString().trim();

        String mailmsg = "\nDear Sir,\n  \t\t\t\t\t\t\tWe are facing some issues in our system kindly go through below details and take the action accordingly\n";
        mailmsg +="\nName:-  "+ name +"\n";
        mailmsg +="\nAddress:-  "+ address +"\n";
        mailmsg +="\nMobileno:-  "+ mobileno +"\n";
        mailmsg += "\nE-mail:-  "+mail+"\n";
        mailmsg +="\nAsset:-  "+ asset +"\n";
        mailmsg +="\nPriority:-  "+priority+"\n";
        mailmsg +="\nDes:-  "+ description +"\n";
        return mailmsg;



    }

    private void addClient()
    {
        String name= Name.getText().toString().trim();
        String address= Address.getText().toString().trim();
        String mobileno=  Mobileno.getText().toString();
        String asset=  Asset.getSelectedItem().toString();
        String description= Des.getText().toString().trim();
        String priority = Priority.getSelectedItem().toString();
        String mail = email.getText().toString().trim();





        if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(address))
        {
            String id =  ticketreference.push().getKey();
            Ticket ticket = new Ticket(name,address,asset,mobileno,asset,description);
            ticketreference.child(id).setValue(ticket);
            Toast.makeText(this,"Ticket Added",Toast.LENGTH_SHORT).show();

           Intent intent =new Intent(Intent.ACTION_SENDTO);
           intent.setData(Uri.parse("mailto:"));
           intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"admin@kumaarakalpa.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT,"Client Ticket");
            intent.putExtra(Intent.EXTRA_TEXT,sendMail());

            startActivity(intent);



        }
        else
        {
            Toast.makeText(this,"You Should enter the Information",Toast.LENGTH_SHORT).show();
        }








    }


}