package com.example.finalprojectinandroid.RoomDataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectinandroid.databinding.LevelitemBinding;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    ArrayList<Level> levelArrayList;
    Context context;

    public LevelAdapter(ArrayList<Level> levelArrayList, Context context) {
        this.levelArrayList = levelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LevelitemBinding binding=LevelitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

holder.Level.setText(levelArrayList.get(position).getLevelnum());
holder.point.setText(levelArrayList.get(position).getRequired_points());
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
