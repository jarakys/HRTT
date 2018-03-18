package com.example.tiberium.hrtt.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiberium.hrtt.Adapters.ChangeAdapter;
import com.example.tiberium.hrtt.App;
import com.example.tiberium.hrtt.Contract.ChangeContract;
import com.example.tiberium.hrtt.Models.Lesson;
import com.example.tiberium.hrtt.Presenters.ChangePresenter;
import com.example.tiberium.hrtt.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class ChangeLessonsFragment extends Fragment implements ChangeContract.View{
    ListView mChangeList;
    ChangePresenter mPresenter;
    TextView mDay;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_lessons, container, false);
        mChangeList = (ListView)view.findViewById(R.id.id_list_change);
        mPresenter = new ChangePresenter(this);
        mDay = (TextView)view.findViewById(R.id.day_of_week);
        return  view;
    }

    @Override
    public void showCurrentChangeList(ArrayList<Lesson> currentLessons) {
        ChangeAdapter changeAdapter = new ChangeAdapter(getContext(),currentLessons);
        mChangeList.setAdapter(changeAdapter);
        SharedPreferences sPref = App.getInstance().getApplicationContext().getSharedPreferences("day_week", Context.MODE_PRIVATE);
        String s = sPref.getString("day_week","");
        mDay.setText(s);
    }

}
