package com.example.dndapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Block_Adapter extends RecyclerView.Adapter<Block_Adapter.Block_View_Holder> {

    ArrayList<Block> mon;
    Fragment1.Ilisner main;

    public Block_Adapter(ArrayList mon, Fragment1.Ilisner main){
        this.mon = mon;
        this.main = main;
    }


    @NonNull
    @Override
    public Block_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block_item, parent, false);
        Block_View_Holder recordViewHolder = new Block_View_Holder(view);
        return recordViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Block_View_Holder holder, int position) {

        View rootView = holder.rootView;
        final int del= position;

        Block cMon = mon.get(position);

        holder.nameID.setText("Name: "+ cMon.getName());
        holder.hpID.setText("HP: "+cMon.getHp());

        // find how to set image view from folder
        // Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(cMon.pick));
        // holder.feeling_image.setImageBitmap(bitmap);




        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Demo", "AAAAAAAAAAAAAA" );

                main.setId(del);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new Fragment2();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.b, myFragment).addToBackStack(null).commit();
            }
        });


    }



    @Override
    public int getItemCount() {
        return this.mon.size();
    }

    public static class Block_View_Holder extends  RecyclerView.ViewHolder {

        TextView nameID;
        TextView hpID;
        ImageView image;
        TextView AcID;
        ProgressBar HpPro;
        View rootView;

        public Block_View_Holder(@NonNull View itemView) {
            super(itemView);

            rootView = itemView;
            nameID = itemView.findViewById(R.id.nameID);
            hpID = itemView.findViewById(R.id.hpID);
            AcID = itemView.findViewById(R.id.acID);
            HpPro = itemView.findViewById(R.id.progressBar3);
            image = itemView.findViewById(R.id.image);
        }
    }
}