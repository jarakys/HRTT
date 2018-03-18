package com.example.tiberium.hrtt.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiberium.hrtt.Adapters.RVAdapter;
import com.example.tiberium.hrtt.Contract.NewsContract;
import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.Presenters.NewsPresenter;
import com.example.tiberium.hrtt.R;

import java.util.ArrayList;

public class NewsFragment extends Fragment  implements  NewsContract.View{

    RVAdapter mRVAdapter;
    View mView;
    RecyclerView mRecyclerView;
    NewsPresenter mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView  =  inflater.inflate(R.layout.fragment_recycler_news, container, false);
        mRecyclerView = (RecyclerView)mView.findViewById(R.id.id_recycle);
        LinearLayoutManager llm  = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);
        mPresenter = new NewsPresenter(this);


        return  mView;
    }


    @Override
    public void refreshCurrentNewsList(ArrayList<News> currentNewsMessage) {
        mRVAdapter = new RVAdapter(currentNewsMessage);
        mRecyclerView.setAdapter(mRVAdapter);
    }
}
