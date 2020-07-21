package com.example.draganddropwithitemviewtype.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.databinding.ItemOneColumnBinding;
import com.example.draganddropwithitemviewtype.viewholder.ItemOneColumnViewHolder;

import java.util.List;

public class OneColumnItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> data;

    public OneColumnItemAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOneColumnBinding binding = ItemOneColumnBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemOneColumnViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemOneColumnViewHolder) holder).bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public List<String> getData() {
        return data;
    }
}
