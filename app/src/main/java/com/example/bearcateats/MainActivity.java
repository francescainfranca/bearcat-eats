package com.example.bearcateats;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bearcateats.adapters.PopularAdapter;
import com.example.bearcateats.adapters.RecommendedAdapter;
import com.example.bearcateats.model.Allmenu;
import com.example.bearcateats.model.FoodData;
import com.example.bearcateats.model.Popular;
import com.example.bearcateats.model.Recommended;
import com.example.bearcateats.retrofit.ApiInterface;
import com.example.bearcateats.retrofit.RetrofitClient;
import com.example.bearcateats.adapters.AllMenuAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<FoodData>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {
                System.out.println("TEST!!!!!!!!!!!!!!");
                List<FoodData> MenuList;
                MenuList = response.body();
                if(MenuList == null) {
                    System.out.println("MenuList!!!!!!!!!!!!!!");
                }

                List <FoodData> test1 = (List<FoodData>) MenuList.get(0);

                List<Popular> popular = ((FoodData) test1).getPopular();

                getPopularData(popular);
                System.out.println("GET POPULAR RAN!!!!!!!!!!!!!!");

                getRecommendedData(MenuList.get(0).getRecommended());
            }

            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}