package com.example.draganddropwithitemviewtype.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.databinding.ItemTitleBinding;

public class TitleViewHolder extends RecyclerView.ViewHolder {
    private ItemTitleBinding binding;

    public TitleViewHolder(@NonNull ItemTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindData(String title) {
        binding.textTitle.setText(title);
    }
}
