package com.example.draganddropwithitemviewtype.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.draganddropwithitemviewtype.viewholder.TitleViewHolder;

import java.util.Collections;

public class ItemTouchListener extends ItemTouchHelper.Callback {
    private RecyclerView.Adapter itemAdapter;

    public ItemTouchListener(RecyclerView.Adapter itemAdapter) {
        this.itemAdapter = itemAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof TitleViewHolder) {
            return makeFlag(0, 0);
        }
        return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        if (target instanceof TitleViewHolder) {
            return false;
        }
        int currentPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();
        if (currentPosition < newPosition) {
            for (int i = currentPosition; i < newPosition; i++) {
                if (itemAdapter instanceof OneColumnItemAdapter) {
                    Collections.swap(((OneColumnItemAdapter) itemAdapter).getData(), i, i + 1);
                }

                if (itemAdapter instanceof TwoColumnItemAdapter) {
                    Collections.swap(((TwoColumnItemAdapter) itemAdapter).getData(), i, i + 1);
                }

                if (itemAdapter instanceof OneColumnWithViewTypeAdapter) {
                    Collections.swap(((OneColumnWithViewTypeAdapter) itemAdapter).getData(), i, i + 1);
                }

                if (itemAdapter instanceof TwoColumnWithViewTypeAdapter) {
                    Collections.swap(((TwoColumnWithViewTypeAdapter) itemAdapter).getData(), i, i + 1);
                }
            }
        } else {
            for (int i = currentPosition; i > newPosition; i--) {
                if (itemAdapter instanceof OneColumnItemAdapter) {
                    Collections.swap(((OneColumnItemAdapter) itemAdapter).getData(), i, i - 1);
                }

                if (itemAdapter instanceof TwoColumnItemAdapter) {
                    Collections.swap(((TwoColumnItemAdapter) itemAdapter).getData(), i, i - 1);
                }

                if (itemAdapter instanceof OneColumnWithViewTypeAdapter) {
                    Collections.swap(((OneColumnWithViewTypeAdapter) itemAdapter).getData(), i, i - 1);
                }

                if (itemAdapter instanceof TwoColumnWithViewTypeAdapter) {
                    Collections.swap(((TwoColumnWithViewTypeAdapter) itemAdapter).getData(), i, i - 1);
                }
            }
        }
        itemAdapter.notifyItemMoved(currentPosition, newPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }
}
