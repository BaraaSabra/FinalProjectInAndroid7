package com.example.finalprojectinandroid.RoomDataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectinandroid.databinding.LevelitemBinding;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    ArrayList<Level> levelArrayList;
    Context context;
    Action action;

    public LevelAdapter(ArrayList<Level> levelArrayList, Context context,Action action) {
        this.levelArrayList = levelArrayList;
        this.context = context;
        this.action=action;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LevelitemBinding binding=LevelitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos=position;
            Level levle=levelArrayList.get(position);
         holder.Level.setText(String.valueOf(levle.getLevelnum()));
         holder.point.setText(String.valueOf(levle.getRequired_points()));
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 action.OnClik(levle.getLevelnum());
             }
         });
    }

    @Override
    public int getItemCount() {
        return levelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView Level,point;


        public ViewHolder( LevelitemBinding binding) {
            super(binding.getRoot());
            Level=binding.tvNumberoflevel;
            point=binding.tvPoint;
        }
    }
}
