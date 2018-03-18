package com.example.tiberium.hrtt.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.tiberium.hrtt.App;
import com.example.tiberium.hrtt.Presenters.ChangePresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 19.11.2017.
 */

public class ChangeModel {
    private DatabaseReference mLessonsElementReference;
    private DatabaseReference mDay = FirebaseDatabase.getInstance().getReference("Information");
    private ChangePresenter mChangePresenter;
    private SharedPreferences mSharedPreferences;

    public ChangeModel(ChangePresenter changePresenter) {
        mChangePresenter = changePresenter;
        mSharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
        String group = mSharedPreferences.getString("Name_Group","ОТ-414");
        mLessonsElementReference  = FirebaseDatabase.getInstance().getReference("Change").child(group);
        retrieveCurrentLesson();
    }

    class DayChange extends AsyncTask<DataSnapshot,Void,Void>
    {


        @Override
        protected Void doInBackground(DataSnapshot... dataSnapshots) {
            String _day  = String.valueOf(dataSnapshots[0].child("day").getValue());
            SharedPreferences sPref = App.getInstance().getApplicationContext().getSharedPreferences("day_week", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed  = sPref.edit();
            ed.putString("day_week",_day);
            ed.commit();
            return null;
        }
    }


    class ChangeTask extends AsyncTask<DataSnapshot,Void,ArrayList<Lesson>>
    {

        @Override
        protected void onPostExecute(ArrayList<Lesson> lessons) {
            super.onPostExecute(lessons);
            mChangePresenter.showCurrentChangeList(lessons);
        }

        @Override
        protected ArrayList<Lesson> doInBackground(DataSnapshot... dataSnapshots) {
             ArrayList<Lesson> mLessons=new ArrayList<>();
            for(DataSnapshot newsSnapshot : dataSnapshots[0].getChildren())
            {
                Lesson lesson = newsSnapshot.getValue(Lesson.class);
                mLessons.add(lesson);
            }
            return mLessons;
        }
    }
    private void retrieveCurrentLesson() {
        mLessonsElementReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new ChangeTask().execute(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new DayChange().execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
