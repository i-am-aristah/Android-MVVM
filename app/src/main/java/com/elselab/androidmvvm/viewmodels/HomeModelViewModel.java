package com.elselab.androidmvvm.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elselab.androidmvvm.models.HomeModel;
import com.elselab.androidmvvm.repositories.HomeModelRepository;

import java.util.List;

public class HomeModelViewModel extends ViewModel {

    private MutableLiveData<List<HomeModel>> dataList;
    private HomeModelRepository repository;

    public void init(){
        if(dataList!=null){
            return;
        }
        repository = HomeModelRepository.getInstance();
        dataList= repository.getHomeData();
        Log.d("TestD",dataList.toString());
    }

    public LiveData<List<HomeModel>> getHomeData()

    {
        repository = HomeModelRepository.getInstance();
        dataList= repository.getHomeData();
        Log.d("TestD",dataList.toString());
        return dataList;
    }
}
