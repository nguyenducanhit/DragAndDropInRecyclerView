package com.example.draganddropwithitemviewtype.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.viewholder.ItemTwoColumnViewHolder;
import com.example.draganddropwithitemviewtype.databinding.ItemTwoColumnBinding;

import java.util.List;

public class TwoColumnItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> data;

    public TwoColumnItemAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTwoColumnBinding binding = ItemTwoColumnBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemTwoColumnViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemTwoColumnViewHolder) holder).bindData(data.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public List<String> getData() {
        return data;
    }
}
