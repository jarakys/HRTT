package com.example.tiberium.hrtt.Models;

/**
 * Created by TIBERIUM on 02.11.2017.
 */

public class Lesson {
    String time;
    String subject;
    String auditory;


    public Lesson(String time, String subject, String auditory) {

        this.time = time;
        this.subject = subject;
        this.auditory = auditory;
    }

    public String getAuditory() {
        return auditory;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }

    public Lesson() {
    }
}
