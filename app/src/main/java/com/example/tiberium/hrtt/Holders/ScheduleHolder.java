package com.example.tiberium.hrtt.Holders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiberium.hrtt.Models.Lesson;
import com.example.tiberium.hrtt.Models.Schedule;
import com.example.tiberium.hrtt.R;

/**
 * Created by TIBERIUM on 28.11.2017.
 */

public class ScheduleHolder extends RecyclerView.ViewHolder{
    private TextView mDay;
    private LinearLayout mLinearLayout;
    private Schedule mSchedule;
    private Context mContext;
    public ScheduleHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mDay = (TextView)itemView.findViewById(R.id.schedule_day_of_week);
        mLinearLayout = (LinearLayout)itemView.findViewById(R.id.main_schedule);
    }
    public  void createScheduleUI(Schedule schedule)
    {
        mSchedule = schedule;
        mDay.setText(mSchedule.getDayOfWeek());
        for(Lesson lesson : mSchedule.getLessons())
        {
            LinearLayout layout = new LinearLayout(mContext);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(params);
            for(int i=0;i<3;i++)
            {
                LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                String data;
                paramsTextView.weight = 1;
                if(i==0)
                {
                    data = lesson.getTime();
                    paramsTextView.weight =0;
                }
                else if(i==1){
                    data = lesson.getSubject();
                }
                else {
                    data = lesson.getAuditory();
                }
                paramsTextView.gravity = Gravity.FILL;
                TextView textView = new TextView(mContext);
                textView.setLayoutParams(paramsTextView);
                textView.setGravity(Gravity.CENTER);
                textView.setLines(3);
                textView.setEms(4);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                textView.setTextColor(Color.BLACK);
                textView.setText(data);
                layout.addView(textView);


            }
            mLinearLayout.addView(layout);
        }
    }
}
