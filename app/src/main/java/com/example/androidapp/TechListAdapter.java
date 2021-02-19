package com.example.androidapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class TechListAdapter extends ArrayAdapter
{
    private Activity mContext;
    List<Technician> technicianList;

    public TechListAdapter( Activity mContext,  List<Technician>technicianList)
    {
        super(mContext, R.layout.tech_list_item,technicianList);

        this.mContext=mContext;
        this.technicianList=technicianList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater =mContext.getLayoutInflater();
        View listItemView=inflater.inflate(R.layout.tech_list_item,null,true);

        TextView tvName=listItemView.findViewById(R.id.tvName);
        TextView tvAddress=listItemView.findViewById(R.id.tvAddress);
        TextView tvtvDoj=listItemView.findViewById(R.id.tvDoj);

        Technician T = technicianList.get(position);

        tvName.setText(T.getName1());
        tvAddress.setText(T.getAddress1());
        tvtvDoj.setText(T.getDoj1());
        return listItemView;

    }
}
