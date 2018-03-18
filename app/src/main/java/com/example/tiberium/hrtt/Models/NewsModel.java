package com.example.tiberium.hrtt.Models;

import android.os.AsyncTask;

import com.example.tiberium.hrtt.Presenters.NewsPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 04.11.2017.
 */

public class NewsModel {
    private DatabaseReference mNewsElementReference = FirebaseDatabase.getInstance().getReference("News");
    private NewsPresenter mPresenter;
    private RetrieveNewsTask mNewsTask;

    public NewsModel(NewsPresenter presenter) {
        this.mPresenter = presenter;
        retrieveCurrentNews();
    }
    class RetrieveNewsTask extends AsyncTask<DataSnapshot,Void,ArrayList<News>>
    {
        @Override
        protected void onPostExecute(ArrayList<News> news) {
            super.onPostExecute(news);
            mPresenter.refreshCurrentNewsList(news);
        }

        @Override
        protected ArrayList<News> doInBackground(DataSnapshot... dataSnapshots) {
            ArrayList<News> mCurrentNewsList = new ArrayList<>();


            for(DataSnapshot newsSnapshot : dataSnapshots[0].getChildren())
            {
                String title = String.valueOf(newsSnapshot.getKey());
                String date = String.valueOf(newsSnapshot.child("date").getValue());

                mCurrentNewsList.add(new News(title,date));
            }
            return mCurrentNewsList;
        }
    }
    private void retrieveCurrentNews() {
        mNewsElementReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mNewsTask = new RetrieveNewsTask();
                mNewsTask.execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
