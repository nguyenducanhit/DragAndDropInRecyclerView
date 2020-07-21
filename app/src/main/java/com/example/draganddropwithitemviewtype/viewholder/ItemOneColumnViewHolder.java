package com.example.draganddropwithitemviewtype.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.databinding.ItemOneColumnBinding;


public class ItemOneColumnViewHolder extends RecyclerView.ViewHolder {
    private ItemOneColumnBinding binding;

    public ItemOneColumnViewHolder(@NonNull ItemOneColumnBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindData(String data) {
        binding.textItem.setText(data);
    }
}
