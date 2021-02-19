package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TechnicianRetrive extends AppCompatActivity {

    ListView myListView;
    List<Technician>technicianList;

    DatabaseReference techDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_retrive);

        myListView =findViewById(R.id.myListViewtech);
        technicianList=new ArrayList<>();

        techDBRef= FirebaseDatabase.getInstance().getReference().child("technician");
        techDBRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                technicianList.clear();
                for( DataSnapshot technicianDataSnap:snapshot.getChildren())
                {
                    Technician t=technicianDataSnap.getValue(Technician.class);
                    technicianList.add(t);

                }

                TechListAdapter adapter=new TechListAdapter(TechnicianRetrive.this,technicianList);
                myListView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }
}