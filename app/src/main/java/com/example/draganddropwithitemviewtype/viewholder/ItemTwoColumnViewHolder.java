package com.example.draganddropwithitemviewtype.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.databinding.ItemTwoColumnBinding;

public class ItemTwoColumnViewHolder extends RecyclerView.ViewHolder {
    private ItemTwoColumnBinding binding;

    public ItemTwoColumnViewHolder(@NonNull ItemTwoColumnBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindData(String data) {
        binding.textTitle.setText(data);
    }
}
