package com.infisoln.siddhant.note_taking_app_sharedprefs;

public class Note {

    private String title, timeStamp;

    public Note(String title, String timeStamp) {
        this.title = title;
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
