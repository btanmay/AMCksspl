package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androidapp.Fragments.ClientsFragment;

public class AdminProfileList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile_list);
        Fragment fragment;
        fragment = new ClientsFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.your_placeholder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
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
                Intent intent = new Intent(AdminProfileList.this,AndroidMain1.class);
                startActivity(intent);
                break;
            case R.id.add_technician:
                Toast.makeText(this, "Technician added", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AdminProfileList.this,TechnicianActivity.class);
                startActivity(intent1);
                break;
            case R.id.technician_details:
                Toast.makeText(this, "Technician details", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(AdminProfileList.this,TechnicianRetrive.class);
                startActivity(intent3);
                break;

            case R.id.view_ticket:
                Toast.makeText(this, "Tickets display", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(AdminProfileList.this,TicketRetriveActivity.class);
                startActivity(intent2);                                        //??????????????????
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}