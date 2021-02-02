package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AndroidMain1 extends AppCompatActivity
{

    EditText Name,Address,Date1,Date2;
    Spinner Asset,Device,Quantity;

    Button Submit;
    DatePickerDialog.OnDateSetListener setListener;


    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_main1);





        reference= FirebaseDatabase.getInstance().getReference().child("client");

        Name =(EditText)findViewById(R.id.name);
        Address =(EditText)findViewById(R.id.address);
        Asset =(Spinner) findViewById(R.id.asset);
        Device =(Spinner) findViewById(R.id.dc);
        Quantity =(Spinner) findViewById(R.id.quantity);
        Date1 =(EditText)findViewById(R.id.tvDate);
        Date2 =(EditText)findViewById(R.id.edDate);
        Submit=(Button) findViewById(R.id.btn_submit);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        Submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               addClient();

           }
       });


        Date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AndroidMain1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month = month + 1;
                        String date = day +"/"+ month + "/" +year;
                        Date1.setText(date);


                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                Date1.setText(date);

            }
        };

        Date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AndroidMain1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override

                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month =month+1;
                        String date =day+"/"+month+"/"+year;
                        Date2.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
    private void addClient()
    {
        String name= Name.getText().toString().trim();
        String address= Address.getText().toString().trim();
        String asset=  Asset.getSelectedItem().toString();
        String company=  Device.getSelectedItem().toString();
        String quantity= Quantity.getSelectedItem().toString();
        String date1= Date1.getText().toString().trim();
        String date2= Date2.getText().toString().trim();

        if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(address))
        {
            String id = reference.push().getKey();
            Client client = new Client(id,name,address,asset,company,quantity,date1,date2);
            reference.child(id).setValue(client);
            Toast.makeText(this,"Client Added",Toast.LENGTH_SHORT).show();



        }
        else
        {
            Toast.makeText(this,"You Should enter the Information",Toast.LENGTH_SHORT).show();

        }


    }

       @Override
         public boolean onCreateOptionsMenu(Menu menu)
          {
            MenuInflater inflater = getMenuInflater();
               inflater.inflate(R.menu.menu1, menu);
                return super.onCreateOptionsMenu(menu);
          }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tickets:
                Intent intent = new Intent(AndroidMain1.this, tickets.class);
                startActivity(intent);
                Toast.makeText(this, "Click on Tickets", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
