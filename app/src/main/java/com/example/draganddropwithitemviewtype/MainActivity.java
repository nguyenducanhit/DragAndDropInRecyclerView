package com.example.draganddropwithitemviewtype;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.draganddropwithitemviewtype.adapter.ItemTouchListener;
import com.example.draganddropwithitemviewtype.adapter.OneColumnItemAdapter;
import com.example.draganddropwithitemviewtype.adapter.OneColumnWithViewTypeAdapter;
import com.example.draganddropwithitemviewtype.adapter.TwoColumnItemAdapter;
import com.example.draganddropwithitemviewtype.adapter.TwoColumnWithViewTypeAdapter;
import com.example.draganddropwithitemviewtype.adapter.ViewType;
import com.example.draganddropwithitemviewtype.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final String FORMAT_ITEM = "Item %d";
    private static final int NUMBER_ITEM = 20;
    private ActivityMainBinding binding;
    private List<String> data = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showData();
    }

    private void initData() {
        data.clear();
        for (int i = 1; i <= NUMBER_ITEM; i++) {
            data.add(String.format(Locale.getDefault(), FORMAT_ITEM, i));
        }
    }

    private void showData() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setItems(R.array.selection, this)
                .create()
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        initData();
        switch (which) {
            case 0:
                adapter = new OneColumnItemAdapter(data);
                break;
            case 1:
                adapter = new TwoColumnItemAdapter(data);
                binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case 2:
                adapter = new OneColumnWithViewTypeAdapter(data);
                break;
            case 3:
                adapter = new TwoColumnWithViewTypeAdapter(data);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (adapter.getItemViewType(position) == ViewType.VIEW_TYPE_TITLE) {
                            return 2;
                        }
                        return 1;
                    }
                });
                binding.recyclerView.setLayoutManager(gridLayoutManager);
                break;
        }
        binding.recyclerView.setAdapter(adapter);
        ItemTouchListener itemTouchListener = new ItemTouchListener(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchListener);
        itemTouchHelper.attachToRecyclerView(binding.recyclerView);
    }
}
