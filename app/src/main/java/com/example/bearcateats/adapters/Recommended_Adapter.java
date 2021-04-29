package com.example.bearcateats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.bearcateats.R;
import com.example.bearcateats.model.Recommended;

import java.util.List;

public class Recommended_Adapter extends RecyclerView.Adapter<Recommended_Adapter.RecommendedViewHolder> {

    private Context context;
    private List<Recommended> recommendedList;

    public Recommended_Adapter(Context context, List<Recommended> recommendedList){
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, int position) {

        holder.recommendedName.setText(recommendedList.get(position).getName());
        holder.recommendedRating.setText(recommendedList.get(position).getRating());
        holder.recommendedCharges.setText(recommendedList.get(position).getDeliveryCharges());
        holder.recommendedDeliveryTime.setText(recommendedList.get(position).getDeliveryTime());
        holder.recommendedPrice.setText("$ "+recommendedList.get(position).getPrice());

        Glide.with(context).load(recommendedList.get(position).getImageURL()).into(holder.recommendedImage);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RecommendedViewHolder extends RecyclerView.ViewHolder{

        ImageView recommendedImage;
        TextView recommendedName, recommendedRating, recommendedDeliveryTime, recommendedCharges, recommendedPrice;

        RecommendedViewHolder(@NonNull View itemView){
            super(itemView);

            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedRating = itemView.findViewById(R.id.recommended_rating);
            recommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time);
            recommendedCharges = itemView.findViewById(R.id.recommended_delivery_type);
            recommendedPrice = itemView.findViewById(R.id.recommended_price);


        }
    }

}
