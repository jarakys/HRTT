package com.example.tiberium.hrtt.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tiberium.hrtt.Models.News;
import com.example.tiberium.hrtt.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        Bundle bundle = getArguments();
        if(bundle!=null){
            News content = (News) bundle.getSerializable("news");
            ((TextView)view.findViewById(R.id.id_title)).setText(content.getTitle());
            ((TextView)view.findViewById(R.id.id_content)).setText(content.getContent());
        }
        return view;
    }

}
