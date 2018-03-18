package com.example.tiberium.hrtt.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tiberium.hrtt.App;
import com.example.tiberium.hrtt.R;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by TIBERIUM on 23.11.2017.
 */

public class Dialog1 extends android.support.v4.app.DialogFragment implements View.OnClickListener {
    View mView;
    SharedPreferences mSharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Группа");
        mView = inflater.inflate(R.layout.custom_dialog,null);
        mView.findViewById(R.id.id_save_group).setOnClickListener(this);

        mSharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
        String s = mSharedPreferences.getString("Name_Group","");
        ((TextView)mView.findViewById(R.id.id_name_group)).setText(s);
        return mView;
    }

    @Override
    public void onClick(View v) {
        String nameGroup  = ((EditText)mView.findViewById(R.id.id_new_name_group)).getText().toString();
        mSharedPreferences = App.getInstance().getApplicationContext().getSharedPreferences("Name_Group", Context.MODE_PRIVATE);
        String s = mSharedPreferences.getString("Name_Group","");
        FirebaseMessaging.getInstance().unsubscribeFromTopic(s);
        FirebaseMessaging.getInstance().subscribeToTopic(nameGroup);
        SharedPreferences.Editor ed  = mSharedPreferences.edit();
        ed.putString("Name_Group",nameGroup);
        ed.commit();
        dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
