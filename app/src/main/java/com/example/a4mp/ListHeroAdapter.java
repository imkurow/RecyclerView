package com.example.a4mp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private Context context; 
    private ArrayList<Heroes> listHeroes;

    public ListHeroAdapter(Context context, ArrayList<Heroes> list){
        this.context = context;
        this.listHeroes = list;

    }

    @NonNull
    @Override
    public ListHeroAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdapter.ListViewHolder holder, int position) {
        Heroes hero = listHeroes.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDesc.setText(hero.getDescription());
        Log.d("Adapter", "Hero Name: " + hero.getName());

    }



    @Override
    public int getItemCount() {
        return listHeroes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
