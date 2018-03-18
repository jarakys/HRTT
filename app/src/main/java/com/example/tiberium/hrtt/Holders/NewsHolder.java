package com.example.tiberium.hrtt.Holders;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tiberium.hrtt.Fragments.ContentFragment;
import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by TIBERIUM on 31.10.2017.
 */

public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTitle;
    private TextView mData;
    private News mNews;
    private Context mContext;
    public NewsHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mTitle = (TextView)itemView.findViewById(R.id.id_news);
        mData = (TextView)itemView.findViewById(R.id.id_time);
        itemView.setOnClickListener(this);
    }
    public void bindCrime( News news)
    {
        mNews = news;
        mTitle.setText(mNews.getTitle());
        mData.setText(mNews.getData());

    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView)v.findViewById(R.id.id_news);
        DatabaseReference DbNews;
        DbNews = FirebaseDatabase.getInstance().getReference("News").child(String.valueOf(textView.getText()));
        final News news = new News(String.valueOf(textView.getText()));

        DbNews.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                news.setContent(String.valueOf(dataSnapshot.child("content").getValue()));
                Bundle bundle = new Bundle();
                bundle.putSerializable("news",news);
                ContentFragment content = new ContentFragment();
                content.setArguments(bundle);
                FragmentManager fTrans;
                fTrans = ((AppCompatActivity)mContext).getSupportFragmentManager();
                fTrans.beginTransaction().replace(R.id.frame,content).addToBackStack(null).commit();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
