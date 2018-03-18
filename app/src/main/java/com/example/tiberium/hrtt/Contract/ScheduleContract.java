package com.example.tiberium.hrtt.Contract;

import com.example.tiberium.hrtt.Models.Schedule;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 26.11.2017.
 */

public interface ScheduleContract {
    interface View
    {
        void showSchedule(ArrayList<Schedule> schedules);
    }
    interface Presenter
    {
        void showSchedule(ArrayList<Schedule> schedules);
        void onClick(String day);
    }
}
