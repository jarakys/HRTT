package com.example.tiberium.hrtt.Contract;

import com.example.tiberium.hrtt.Models.Lesson;

import java.util.ArrayList;

/**
 * Created by TIBERIUM on 19.11.2017.
 */

public interface ChangeContract {
    interface  View{
        void showCurrentChangeList(ArrayList<Lesson> currentLessons);
    }
    interface  Presenter {
        void showCurrentChangeList(ArrayList<Lesson> currentLessons);
    }
}
