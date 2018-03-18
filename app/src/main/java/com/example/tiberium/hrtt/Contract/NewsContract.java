package com.example.tiberium.hrtt.Contract;

import com.example.tiberium.hrtt.Models.News;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 04.11.2017.
 */

public interface NewsContract {
    interface  View{
        void refreshCurrentNewsList(ArrayList<News> currentNewsMessage);
    }
    interface  Presenter {
        void refreshCurrentNewsList(ArrayList<News> currentNewsMessage);
    }
}
