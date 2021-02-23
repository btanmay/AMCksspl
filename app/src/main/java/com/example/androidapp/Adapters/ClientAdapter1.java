package com.example.androidapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapp.Compney;
import com.example.androidapp.ProfilePage;
import com.example.androidapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ClientAdapter1 extends FirebaseRecyclerAdapter<Compney,ClientAdapter1.ClientAdapter1ViewHolder>
{

    public ClientAdapter1(@NonNull FirebaseRecyclerOptions<Compney> options)

    {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull ClientAdapter1ViewHolder clientAdapter1ViewHolder, int i, @NonNull Compney compney)
    {
        clientAdapter1ViewHolder.Name.setText(compney.getName());
        clientAdapter1ViewHolder.Address.setText(compney.getAddress());
        Picasso.get().load(compney.getImage()).placeholder(R.drawable.profile).into(clientAdapter1ViewHolder.imageView);

        clientAdapter1ViewHolder.imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                AppCompatActivity activity=(AppCompatActivity)v.getContext();

                Intent intent=new Intent(activity, ProfilePage.class);

                intent.putExtra("name",compney.getName());
                intent.putExtra("address",compney.getAddress());
                intent.putExtra("asset",compney.getAsset());
                intent.putExtra("company",compney.getCompany());
                intent.putExtra("quantity",compney.getQuantity());
                intent.putExtra("date1",compney.getDate1());
                intent.putExtra("date2",compney.getDate2());

                activity.startActivity(intent);


            }
        });



    }

    @NonNull
    @Override
    public ClientAdapter1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_show_client,parent,false);
        return new ClientAdapter1ViewHolder(view);
    }

    class ClientAdapter1ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView imageView;
        TextView Name,Address;

        public ClientAdapter1ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.profileimage1);
            Name=itemView.findViewById(R.id.userName);
            Address=itemView.findViewById(R.id.address1);
        }
    }
}

