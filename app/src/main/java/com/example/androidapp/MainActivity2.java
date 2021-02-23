package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidapp.Fragments.recfragment;

public class MainActivity2 extends AppCompatActivity
{
    //kiran profile page code

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).commit();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin ,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_client:
                Toast.makeText(this, "Client Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this,AndroidMain1.class);
                startActivity(intent);
                break;
            case R.id.add_technician:
                Toast.makeText(this, "Technician added", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity2.this,TechnicianActivity.class);
                startActivity(intent1);
                break;
            case R.id.technician_details:
                Toast.makeText(this, "Technician details", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainActivity2.this,TechnicianRetrive.class);
                startActivity(intent3);
                break;

            case R.id.view_ticket:
                Toast.makeText(this, "Tickets display", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity2.this,TicketRetriveActivity.class);
                startActivity(intent2);
                break;

        }


        return super.onOptionsItemSelected(item);
    }


}