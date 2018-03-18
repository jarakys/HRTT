package com.example.tiberium.hrtt.Presenters;

import com.example.tiberium.hrtt.Contract.ChangeContract;
import com.example.tiberium.hrtt.Models.ChangeModel;
import com.example.tiberium.hrtt.Models.Lesson;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 19.11.2017.
 */

public class ChangePresenter implements ChangeContract.Presenter {
    private ChangeContract.View mView;
    private ChangeModel mChangeModel;

    public ChangePresenter(ChangeContract.View view) {
        mView = view;
        mChangeModel = new ChangeModel(this);
    }

    @Override
    public void showCurrentChangeList(ArrayList<Lesson> currentLessons) {
        mView.showCurrentChangeList(currentLessons);
    }

    public ChangeContract.View getView() {
        return mView;
    }
}
