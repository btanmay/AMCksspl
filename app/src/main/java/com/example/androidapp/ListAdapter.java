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

public class ListAdapter extends ArrayAdapter
{
    private Activity mContext;
    List<Client> clientList;


    public ListAdapter(Activity mContext, List<Client> clientList)
    {
        super(mContext, R.layout.list_item,clientList);

        this.mContext=mContext;
        this.clientList=clientList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater=mContext.getLayoutInflater();
        View listItemView =inflater.inflate(R.layout.list_item,null,true);

        TextView tvName =listItemView.findViewById(R.id.tvName);
        TextView tvAddress =listItemView.findViewById(R.id.tvAddress);
        TextView tvAsset =listItemView.findViewById(R.id.tvAsset);
        TextView tvDc =listItemView.findViewById(R.id.tvDc);
        TextView tvQuantity =listItemView.findViewById(R.id.tvQuantity);
        TextView tvSd =listItemView.findViewById(R.id.tvSd);
        TextView tvEd =listItemView.findViewById(R.id.tvEd);

        Client client=clientList.get(position);
        tvName.setText(client.getName());
        tvAddress .setText(client.getAddress());
        tvAsset.setText(client.getAsset());
        tvDc.setText(client.getCompany());
        tvQuantity.setText(client.getQuantity());
        tvSd.setText(client.getDate1());
        tvEd.setText(client.getDate2());
        return listItemView;
    }


}
