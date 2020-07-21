package com.example.draganddropwithitemviewtype.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.databinding.ItemTitleBinding;
import com.example.draganddropwithitemviewtype.databinding.ItemTwoColumnBinding;
import com.example.draganddropwithitemviewtype.viewholder.ItemTwoColumnViewHolder;
import com.example.draganddropwithitemviewtype.viewholder.TitleViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TwoColumnWithViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> data;

    public TwoColumnWithViewTypeAdapter(List<String> data) {
        this.data = new ArrayList<>();
        this.data.add("List 1");
        this.data.addAll(data);
        this.data.add(10, "List 2");
    }

    @Override
    public int getItemViewType(int position) {
        if (isTitle(position)) {
            return ViewType.VIEW_TYPE_TITLE;
        }
        return ViewType.VIEW_TYPE_DATA;
    }

    private boolean isTitle(int position) {
        return data.get(position).equals("List 1") || data.get(position).equals("List 2");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ViewType.VIEW_TYPE_DATA) {
            ItemTwoColumnBinding binding = ItemTwoColumnBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ItemTwoColumnViewHolder(binding);
        }
        ItemTitleBinding binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TitleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemTwoColumnViewHolder) {
            ((ItemTwoColumnViewHolder) holder).bindData(data.get(position));
        }
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).bindData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public List<String> getData() {
        return data;
    }
}
