package com.example.androidapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.androidapp.Compney;
import com.example.androidapp.R;

public class descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String name,address,asset,company,quantity,date1, date2;

    public descfragment(String name)
    {

    }

    public descfragment()
    {

        this.name = name;
        this.address = address;
        this.asset = asset;
        this.company = company;
        this.quantity = quantity;
        this.date1 = date1;
        this.date2 = date2;

    }


    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment(Compney.class.getName());
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_descfragment, container, false);


        TextView name1=view.findViewById(R.id.name1);
        TextView  address1=view.findViewById(R.id.address1);
        TextView asset1=view.findViewById(R.id.asset1);
        TextView dc1=view.findViewById(R.id.dc1);
        TextView  quantity1=view.findViewById(R.id.quantity1);
        TextView  tvDate1=view.findViewById(R.id.tvDate1);
        TextView  edDate1=view.findViewById(R.id.edDate1);

        name1.setText(name);
        address1.setText(address);
        asset1.setText(asset);
        dc1.setText(company);
        quantity1.setText(quantity);
        tvDate1.setText(date1);
        edDate1.setText(date2);
        return view;
    }

    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.wrapper, new descfragment(Compney.class.getName()))
                .addToBackStack(null).commit();

    }
}
