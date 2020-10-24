package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter {


    Context context;


    public FavAdapter(Context context) {

        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favrvlay, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        //first page
       ((ViewHolder) holder).img.setImageResource(FavClass.img.get(position));
        ((ViewHolder) holder).releasedate.setText("Release Date: " + FavClass.date.get(position) + "");
        ((ViewHolder) holder).name.setText(FavClass.name.get(position) + "");
        ((ViewHolder) holder).sum.setText(FavClass.sum.get(position) + "");

        FavClass.name.get(0);

        //second page
//        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FavClass fa = new FavClass();
//                Intent intent = new Intent(context, Chosen.class);
//                intent.putExtra("Books",fa.getBook());
//                context.startActivity(intent);
//
//            }
//        });

        ((ViewHolder) holder).del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MainMenu.class);
                context.startActivity(intent);
                Toast.makeText(context, "You can now choose another favorite book", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1 ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView releasedate;
        public TextView sum;
        public TextView del;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img = itemView.findViewById(R.id.imageView3);
            name = itemView.findViewById(R.id.Title2);
            releasedate = itemView.findViewById(R.id.Re2);
            del = itemView.findViewById(R.id.hhh);
            sum = itemView.findViewById(R.id.Sum2);


        }


    }


}
