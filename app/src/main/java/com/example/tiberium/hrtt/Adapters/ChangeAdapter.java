package com.example.tiberium.hrtt.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiberium.hrtt.Models.Lesson;
import com.example.tiberium.hrtt.R;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 02.11.2017.
 */

public class ChangeAdapter extends ArrayAdapter<Lesson>
{
    public ChangeAdapter(@NonNull Context context, @NonNull ArrayList<Lesson> objects) {
        super(context, R.layout.change_list, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Lesson lesson = getItem(position);

        if(convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.change_list,null);
        }
        ((TextView) convertView.findViewById(R.id.id_time_lesson)).setText(lesson.getTime());
        ((TextView) convertView.findViewById(R.id.id_subject)).setText(lesson.getSubject());
        ((TextView) convertView.findViewById(R.id.id_auditory)).setText(lesson.getAuditory());
        return  convertView;
    }
}
