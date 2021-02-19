package com.example.androidapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidapp.R;
import com.example.androidapp.Ticket;
import com.example.androidapp.Ticket2;

import java.util.List;

public class TicketListAdapter extends ArrayAdapter
{
    private Activity mContext;
    List<Ticket2> ticketList2;
    public TicketListAdapter(Activity mContext, List<Ticket2> ticketList)
    {
        super(mContext, R.layout.ticket_list_item,ticketList);
        this.mContext=mContext;

        this.ticketList2 = ticketList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater =mContext.getLayoutInflater();
        View listItemView=inflater.inflate(R.layout.ticket_list_item,null,true);

        TextView tic_fullname=listItemView.findViewById(R.id. tic_fullname);
        TextView tic_address=listItemView.findViewById(R.id.tic_address);
        TextView tic_phno=listItemView.findViewById(R.id.tic_phno);
        TextView tic_des=listItemView.findViewById(R.id.tic_des);

        Ticket2 T = ticketList2.get(position);

        tic_fullname.setText(T.getFname1());
        tic_address.setText(T.getAddress1());
        tic_phno.setText(T.getPhno1());
        tic_des.setText(T.getDes1());


        return listItemView;
    }
}
