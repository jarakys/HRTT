package com.example.tiberium.hrtt.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tiberium.hrtt.App;
import com.example.tiberium.hrtt.Dialog.Dialog1;
import com.example.tiberium.hrtt.R;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    public SettingsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =  inflater.inflate(R.layout.fragment_settings, container, false);
        Button dialog = (Button)view.findViewById(R.id.id_change_group);
        Button push = (Button)view.findViewById(R.id.id_push);

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences;
                sharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("switchPush", Context.MODE_PRIVATE);
                String push = sharedPreferences.getString("switchPush","true");
                if(push.equals("true"))
                {
                    sharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
                    String topic = sharedPreferences.getString("Name_Group","");
                    FirebaseMessaging.getInstance().subscribeToTopic(topic);
                }
                else if(push.equals("false")){

                }

            }
        });



        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new Dialog1();
                dialog.show(getFragmentManager(),"dlg");
            }
        });

        return view;
    }

}
