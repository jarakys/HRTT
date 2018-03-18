package com.example.tiberium.hrtt.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TIBERIUM on 26.11.2017.
 */

public class Schedule implements Serializable {
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    String dayOfWeek;
    ArrayList<Lesson> lessons;
    public Schedule(String dayOfWeek, ArrayList<Lesson> lessons) {
        this.dayOfWeek = dayOfWeek;
        this.lessons = lessons;
    }


}
