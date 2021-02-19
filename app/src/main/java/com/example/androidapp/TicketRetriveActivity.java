package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.androidapp.Adapters.TicketListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TicketRetriveActivity extends AppCompatActivity {

    ListView myListView1;
    List<Ticket2> ticketList;
    DatabaseReference ticketDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_retrive);


        myListView1 =findViewById(R.id.myListView1);
        ticketList=new ArrayList<Ticket2>();

        ticketDBRef= FirebaseDatabase.getInstance().getReference().child("ticket");
        ticketDBRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                ticketList.clear();
                for( DataSnapshot ticketDataSnap:snapshot.getChildren())
                {
                    Ticket2 t=ticketDataSnap.getValue(Ticket2.class);
                    ticketList.add(t);

                }

                TicketListAdapter adapter=new  TicketListAdapter(TicketRetriveActivity.this,ticketList);
                myListView1.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }
}