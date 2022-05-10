package com.elselab.androidmvvm.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elselab.androidmvvm.R;
import com.elselab.androidmvvm.models.HomeModel;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    Context mCtx;
    List<HomeModel> dataList;


    public HomeAdapter(Context mCtx, List<HomeModel> dataList) {
        this.mCtx = mCtx;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(mCtx).inflate(R.layout.home_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder holder, int position) {

        HomeModel  data = dataList.get(position);
        holder.txt.setText(data.getName());

        Glide.with(mCtx).load(data.getImg_url()).placeholder(R.drawable.ic_launcher_background)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {

            return dataList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);
            txt = itemView.findViewById(R.id.textView);
        }
    }
}
