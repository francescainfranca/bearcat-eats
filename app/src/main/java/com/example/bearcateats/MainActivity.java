package com.example.bearcateats;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bearcateats.adapters.Popular_Adapter;
import com.example.bearcateats.adapters.Recommended_Adapter;
import com.example.bearcateats.model.Menu;
import com.example.bearcateats.model.Popular;
import com.example.bearcateats.model.Recommended;
import com.example.bearcateats.retrofit.ApiInterface;
import com.example.bearcateats.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    Popular_Adapter popularAdapter;
    Recommended_Adapter recommendedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<Menu>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                System.out.println("TEST!!!!!!!!!!!!!!");
                List<Menu> MenuList;
                MenuList = response.body();
                if(MenuList == null) {
                    System.out.println("MenuList!!!!!!!!!!!!!!");
                }

                List <Menu> test1 = (List<Menu>) MenuList.get(0);

                List<Popular> popular = ((Menu) test1).getPopular();

                getPopularData(popular);
                System.out.println("GET POPULAR RAN!!!!!!!!!!!!!!");

                getRecommendedData(MenuList.get(0).getRecommended());
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new Popular_Adapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new Recommended_Adapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }
}