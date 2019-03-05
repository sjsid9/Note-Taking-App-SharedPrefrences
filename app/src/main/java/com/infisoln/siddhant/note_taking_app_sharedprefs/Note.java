package com.infisoln.siddhant.note_taking_app_sharedprefs;

class Note {

    private String title, timeStamp;

    Note(String title, String timeStamp) {
        this.title = title;
        this.timeStamp = timeStamp;
    }

    String getTitle() {
        return title;
    }

    String getTimeStamp() {
        return timeStamp;
    }

}
