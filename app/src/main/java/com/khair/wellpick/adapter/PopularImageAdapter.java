package com.khair.wellpick.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularImageAdapter extends RecyclerView.Adapter<PopularImageAdapter.PopularImageViewHolder> {

    @NonNull
    @Override
    public PopularImageAdapter.PopularImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularImageAdapter.PopularImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PopularImageViewHolder extends RecyclerView.ViewHolder {
        public PopularImageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
