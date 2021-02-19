package com.example.androidapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidapp.Adapters.ClientAdapter;
import com.example.androidapp.AndroidMain;
import com.example.androidapp.Client;
import com.example.androidapp.MainActivity;
import com.example.androidapp.R;
import com.example.androidapp.SignInActivity;
import com.example.androidapp.databinding.FragmentClientsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientsFragment#} factory method to
 * create an instance of this fragment.
 */
public class ClientsFragment extends Fragment {

FragmentClientsBinding binding;
ArrayList<Client> list=new ArrayList<>();
FirebaseDatabase database;

      public ClientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentClientsBinding.inflate(inflater,container,false);

        database= FirebaseDatabase.getInstance();
        ClientAdapter adapter =new ClientAdapter(list,getContext());

        binding.clientRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.clientRecyclerView.setLayoutManager(layoutManager);


        database.getReference().child("client").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Client client =dataSnapshot.getValue(Client.class);
                    client.setId(dataSnapshot.getKey());
                    list.add(client);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return binding.getRoot();
    }




}