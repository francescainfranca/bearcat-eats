package com.example.bearcateats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bearcateats.R;
import com.example.bearcateats.model.Popular;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Popular_View_Holder> {

    private Context context;
    private List<Popular> popularList;

    public PopularAdapter(Context context, List<Popular> popularList){
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public Popular_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);

        return new Popular_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Popular_View_Holder holder, int position) {

        holder.popularName.setText(popularList.get(position).getName());

        Glide.with(context).load(popularList.get(position).getImageURL()).into(holder.popularImage);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class Popular_View_Holder extends RecyclerView.ViewHolder {

        ImageView popularImage;
        TextView popularName;

        public Popular_View_Holder(@NonNull View itemView){
            super(itemView);

            popularName = itemView.findViewById(R.id.popular_name);
            popularImage = itemView.findViewById(R.id.popular_image);

        }
    }
}
