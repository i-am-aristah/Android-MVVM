package com.elselab.androidmvvm.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.elselab.androidmvvm.R;
import com.elselab.androidmvvm.models.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeModelRepository {

    public static HomeModelRepository instance;
    public List<HomeModel> dataList;
    public MutableLiveData <List<HomeModel>> mHomeData;

    public static HomeModelRepository getInstance(){
        if(instance==null){
            return new HomeModelRepository();
        }
        return instance;
    }


    public MutableLiveData<List<HomeModel>> getHomeData(){
        setHomeData();


        mHomeData = new MutableLiveData<>();

        mHomeData.setValue(dataList);
        return mHomeData;


    }

    public  void setHomeData() {

        dataList = new ArrayList<>();

        dataList.add(new HomeModel("Nani", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("Name", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("James", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("Annita", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("Wandani", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("Desmond", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
        dataList.add(new HomeModel("Onana", "\"https://pmcfootwearnews.files.wordpress.com/2015/06/michael-jordan-chicago-bulls.jpg\""));
    }
}
