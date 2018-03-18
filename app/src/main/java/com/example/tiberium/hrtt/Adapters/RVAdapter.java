package com.example.tiberium.hrtt.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiberium.hrtt.Holders.NewsHolder;
import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.R;

import java.util.List;

/**
 * Created by TIBERIUM on 31.10.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<NewsHolder> {

    private List<News> mNewses;

    public RVAdapter(List<News> newses) {
        mNewses = newses;
    }


    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list,parent,false);

        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News news = mNewses.get(position);
        holder.bindCrime(news);
    }

    @Override
    public int getItemCount() {
        return mNewses.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
