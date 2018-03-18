package com.example.tiberium.hrtt.Presenters;

import com.example.tiberium.hrtt.Contract.ScheduleContract;
import com.example.tiberium.hrtt.Models.Schedule;
import com.example.tiberium.hrtt.Models.ScheduleModel;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 26.11.2017.
 */

public class SchedulePresenter implements ScheduleContract.Presenter {
    private ScheduleContract.View mView;
    private ScheduleModel mScheduleModel;

    public SchedulePresenter(ScheduleContract.View view) {
        mView = view;
        mScheduleModel = new ScheduleModel(this);
    }

    @Override
    public void showSchedule(ArrayList<Schedule> schedules) {
        mView.showSchedule(schedules);
    }

    @Override
    public void onClick(String day) {
        mScheduleModel.showSchedule(day);
    }
}
