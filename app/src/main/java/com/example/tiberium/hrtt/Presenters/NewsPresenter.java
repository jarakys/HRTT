package com.example.tiberium.hrtt.Presenters;

import com.example.tiberium.hrtt.Contract.NewsContract;
import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.Models.NewsModel;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 04.11.2017.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private  NewsContract.View mView;
    private NewsModel mNewsModel;
    public NewsPresenter(NewsContract.View view) {
        mView = view;
        mNewsModel = new NewsModel(this);
    }

    @Override
    public void refreshCurrentNewsList(ArrayList<News> currentNewsMessage) {
        mView.refreshCurrentNewsList(currentNewsMessage);
    }
}
