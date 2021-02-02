package com.example.androidapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapp.Client;
import com.example.androidapp.ClientDetail;
import com.example.androidapp.MainActivity;
import com.example.androidapp.Models.Users;
import com.example.androidapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    ArrayList<Client> list;
    Context context;

    public ClientAdapter(ArrayList<Client> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_client, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Client client = list.get(position);
        holder.user.setText(client.getName());
       /* holder.address.setText(client.getAddress());
        holder.asset.setText(client.getAsset());
        holder.company.setText(client.getCompany());
        holder.quantity.setText(client.getQuantity());
        holder.date1.setText(client.getDate1());
        holder.date2.setText(client.getDate2());
*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("userId", client.getId());
                intent.putExtra("userName", client.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    ///







    ///



/*
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView user;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.usernameList);
        }


    }
*/
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView user,address,asset,company,quantity,date1,date2;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        user=(TextView)itemView.findViewById(R.id.usernameList);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position= getAdapterPosition();

        Intent intent = new Intent(context,ClientDetail.class);
        context.startActivity(intent);
        intent.putExtra("name",list.get(position).getName());
        intent.putExtra("address",list.get(position).getAddress());
        intent.putExtra("asset",list.get(position).getAsset());
        intent.putExtra("company",list.get(position).getCompany());
        intent.putExtra("quantity",list.get(position).getQuantity());
        intent.putExtra("date1",list.get(position).getDate1());
        intent.putExtra("date2",list.get(position).getDate2());
        Toast.makeText(context, "Client details"+position, Toast.LENGTH_SHORT).show();
    }

    }
}
