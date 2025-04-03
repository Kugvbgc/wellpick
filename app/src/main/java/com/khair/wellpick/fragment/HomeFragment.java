package com.khair.wellpick.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.khair.wellpick.R;
import com.khair.wellpick.adapter.CategoryAdapter;
import com.khair.wellpick.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List<Category> categoryList;
    CategoryAdapter adapter;
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
           View Homeview=inflater.inflate(R.layout.fragment_home, container, false);
           if (container!=null)container.removeAllViews();

           recyclerView = Homeview.findViewById(R.id.Category_recyclerView);
           recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

           loadCategories();

           categoryList = new ArrayList<>();
           adapter = new CategoryAdapter(getContext(), categoryList);
           recyclerView.setAdapter(adapter);









        return Homeview;
    }///*******************************************************************************************

    private void loadCategories() {
        String url = "https://yourwebsite.com/categories.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            categoryList.add(new Category(
                                    obj.getInt("id"),
                                    obj.getString("name"),
                                    obj.getString("image_url")
                            ));
                        }
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(getContext(), "Error loading data", Toast.LENGTH_SHORT).show());

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }






}//***********************************************************************************************