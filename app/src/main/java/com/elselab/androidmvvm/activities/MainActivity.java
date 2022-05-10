package com.elselab.androidmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.elselab.androidmvvm.R;
import com.elselab.androidmvvm.adapters.HomeAdapter;
import com.elselab.androidmvvm.models.HomeModel;
import com.elselab.androidmvvm.repositories.HomeModelRepository;
import com.elselab.androidmvvm.viewmodels.HomeModelViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    LinearLayoutManager layoutManager;
    HomeAdapter adapter;
    HomeModelViewModel mhome;
    HomeModelRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);

        repo = HomeModelRepository.getInstance();

        Log.d("Makini",repo.getHomeData().toString());

        mhome = ViewModelProviders.of(this).get(HomeModelViewModel.class);
        mhome.init();
        mhome.getHomeData().observe(this, new Observer<List<HomeModel>>() {
            @Override
            public void onChanged(List<HomeModel> homeModels) {
                adapter.notifyDataSetChanged();

            }
        });

        adapter= new HomeAdapter(this,repo.getHomeData().getValue());
        rcv.setAdapter(adapter);

    }
}