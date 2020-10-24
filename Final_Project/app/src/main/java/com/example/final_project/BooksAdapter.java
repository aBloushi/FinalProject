package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class BooksAdapter extends RecyclerView.Adapter {

    ArrayList<Books> pArray;
    Context context;


    public BooksAdapter(ArrayList<Books> pArray, Context context) {
        this.pArray = pArray;
        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        //first page
        ((ViewHolder) holder).img.setImageResource(pArray.get(position).getImage());
        ((ViewHolder) holder).releasedate.setText("Release Date: " + pArray.get(position).getReleaseDate() + "");
        ((ViewHolder) holder).name.setText(pArray.get(position).getName() + "");


        //second page
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Chosen.class);
                intent.putExtra("Books", pArray.get(position));
                context.startActivity(intent);

            }
        });
        final ArrayList<String> pp = new ArrayList<>();
        final ArrayList<String> dd = new ArrayList<>();
        final ArrayList<Integer> ii = new ArrayList<>();
        final ArrayList<String> pd = new ArrayList<>();
        final ArrayList<String> su = new ArrayList<>();
        final int i = 0;

        ((ViewHolder) holder).fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ti = pArray.get(position).getName();
                String da = pArray.get(position).getReleaseDate();
                int im = pArray.get(position).getImage();
                String pdf = pArray.get(position).getPdfname();
                String sum = pArray.get(position).getSum();

                pp.add(ti);
                dd.add(da);
                ii.add(im);
                pd.add(pdf);
                su.add(sum);
                final FavClass fav = new FavClass(pp, dd, ii, pd, su);


                Toast.makeText(context, "The book has been added to your favorite  book page", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return pArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView releasedate;
        public TextView fav;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            releasedate = itemView.findViewById(R.id.textView3);
            fav = itemView.findViewById(R.id.hhh);


        }


    }


}
