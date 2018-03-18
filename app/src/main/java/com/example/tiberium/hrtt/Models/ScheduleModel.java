package com.example.tiberium.hrtt.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.tiberium.hrtt.App;
import com.example.tiberium.hrtt.Presenters.SchedulePresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by TIBERIUM on 26.11.2017.
 */

public class ScheduleModel {
    private DatabaseReference mScheduleElementReference;
    private SchedulePresenter mSchedulePresenter;
    private SharedPreferences mSharedPreferences;
    public ScheduleModel(SchedulePresenter schedulePresenter) {
        mSharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
        String group = mSharedPreferences.getString("Name_Group","ОТ-414");
        mScheduleElementReference  =  FirebaseDatabase.getInstance().getReference("Change").child("Schedule").child(group);
        mSchedulePresenter = schedulePresenter;
        showSchedule("Все");

    }
    class ScheduleTask extends AsyncTask<DataSnapshot,Void,ArrayList<Schedule>>
    {
       private String day;


        public ScheduleTask(String day) {

            this.day = day;
        }

        @Override
        protected void onPostExecute(ArrayList<Schedule> schedules) {
            super.onPostExecute(schedules);
            mSchedulePresenter.showSchedule(schedules);
        }

        @Override
        protected ArrayList<Schedule> doInBackground(DataSnapshot... dataSnapshots) {
            ArrayList<Schedule> schedules = new ArrayList<>();
            for(DataSnapshot scheduleSnapshot : dataSnapshots[0].getChildren())
            {
                GenericTypeIndicator<ArrayList<Lesson>> t = new GenericTypeIndicator<ArrayList<Lesson>>() {};
                String dayOfWeek = scheduleSnapshot.getKey().toString();
                if(day =="Все") {


                    ArrayList<Lesson> lessons = scheduleSnapshot.getValue(t);
                    lessons.removeAll(Collections.singleton(null));
                    Schedule schedule = new Schedule(dayOfWeek, lessons);
                    schedules.add(schedule);
                }
                else {
                    if(day.equals(dayOfWeek)){
                        ArrayList<Lesson> lessons = scheduleSnapshot.getValue(t);
                        lessons.removeAll(Collections.singleton(null));
                        Schedule schedule = new Schedule(dayOfWeek, lessons);
                        schedules.add(schedule);
                        break;
                    }
                }
            }
            return schedules;
        }
    }


    public void showSchedule(final String day)
    {
        mScheduleElementReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ScheduleTask task = new ScheduleTask(day);
                task.execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
