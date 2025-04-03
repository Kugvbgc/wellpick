package com.khair.wellpick.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.khair.wellpick.R;
import com.khair.wellpick.activity.SearchActivity;
import com.khair.wellpick.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View inflaterView=inflater.inflate(R.layout.category,parent,false);
        return new ViewHolder(inflaterView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SearchActivity.class);
            intent.putExtra("category_id", categoryList.get(position).getId());
            v.getContext().startActivity(intent);
        });
    }

   @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            cardView=itemView.findViewById(R.id.CardView);

        }
    }
}
