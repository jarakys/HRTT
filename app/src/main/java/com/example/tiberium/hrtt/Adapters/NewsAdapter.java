package com.example.tiberium.hrtt.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.R;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 26.10.2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, @NonNull ArrayList<News> objects) {
        super(context, R.layout.news_list, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        News news = getItem(position);
        if(convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list,null);
        }
        ((TextView) convertView.findViewById(R.id.id_news)).setText(news.getTitle());
        ((TextView) convertView.findViewById(R.id.id_time)).setText(news.getData());
        return  convertView;
    }
}
