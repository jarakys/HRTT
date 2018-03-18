package com.example.tiberium.hrtt.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiberium.hrtt.Adapters.ScheduleAdapter;
import com.example.tiberium.hrtt.Contract.ScheduleContract;
import com.example.tiberium.hrtt.Models.Schedule;
import com.example.tiberium.hrtt.Presenters.SchedulePresenter;
import com.example.tiberium.hrtt.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements ScheduleContract.View {

    TabLayout mTabLayout;
    SchedulePresenter mPresenter;
    RecyclerView mRecyclerView;
    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule,container,false);
        mPresenter = new SchedulePresenter(this);
        LinearLayoutManager llm  = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView)view.findViewById(R.id.schedule_recycler);
        mRecyclerView.setLayoutManager(llm);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Все").setTag("Все"),true );
        mTabLayout.addTab(mTabLayout.newTab().setText("Пн").setTag("Понедельник"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Вт").setTag("Вторник"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Ср").setTag("Среда"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Чт").setTag("Четверг"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Пт").setTag("Пятница"));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPresenter.onClick(tab.getTag().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        return view;
    }

    @Override
    public void showSchedule(ArrayList<Schedule> schedules) {
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(schedules);
        mRecyclerView.setAdapter(scheduleAdapter);

    }
}
