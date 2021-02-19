package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TechnicianActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private String[] pickerVals;
    EditText doj,nameTechnician,addressTechnician;
    Button Submit;
    DatabaseReference Techreference;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician);
        Techreference= FirebaseDatabase.getInstance().getReference().child("technician");


        numberPicker= findViewById(R.id.experience);
        doj = findViewById(R.id.t_doj);
        nameTechnician= findViewById(R.id.name);
        addressTechnician=findViewById(R.id.address);
        Submit = findViewById(R.id.btn);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(5);

        pickerVals= new String[] {"Fresher","1 year","2 years","3 years","4 years","5+ years"};

        numberPicker.setDisplayedValues(pickerVals);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        doj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(TechnicianActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month = month + 1;
                        String date = day +"/"+ month + "/" +year;
                        doj.setText(date);


                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                doj.setText(date);

            }
        };

        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addTech();

            }

        });



    }

    private void addTech() {

        String Name1=  nameTechnician.getText().toString().trim();
        String Address1=  addressTechnician.getText().toString().trim();
        String Doj1=  doj.getText().toString().trim();





        if((!TextUtils.isEmpty(Name1)) && (!TextUtils.isEmpty(Address1)) && (!TextUtils.isEmpty(Doj1)))
        {
            String id = Techreference.push().getKey();
            Technician t = new Technician(id, Name1,Address1,Doj1);

            Techreference.child(id).setValue(t);
            Toast.makeText(this,"Technician Added",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this,"You Should enter the Information",Toast.LENGTH_SHORT).show();

        }




    }
}