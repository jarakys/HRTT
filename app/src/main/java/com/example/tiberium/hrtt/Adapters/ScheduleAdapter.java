package com.example.tiberium.hrtt.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiberium.hrtt.Holders.ScheduleHolder;
import com.example.tiberium.hrtt.Models.Schedule;
import com.example.tiberium.hrtt.R;

import java.util.List;

/**
 * Created by TIBERIUM on 27.11.2017.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleHolder>
{

    private List<Schedule> mScheduleList;

    public ScheduleAdapter(List<Schedule> scheduleList) {
        mScheduleList = scheduleList;
    }

    @Override
    public ScheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_schedule,parent,false);
        return new ScheduleHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleHolder holder, int position) {
        Schedule schedule = mScheduleList.get(position);
        holder.createScheduleUI(schedule);
    }

    @Override
    public int getItemCount() {
        return mScheduleList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
