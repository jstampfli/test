package com.pccaps.pmiconference;

/**
 * Created by User1 on 10/3/2017.
 */


public class Event {
    String speaker;
    int STime;
    int ETime;
    String P;
    String D;
    String subject;
    int date;
    int rating;

    public Event(String name, int st, int et, String place, String Description, String topic, int day, int rating){
        speaker=name;
        STime=st;
        ETime=et;
        P=place;
        D=Description;
        subject=topic;
        date=day;
        this.rating=rating;
    }
    public String toString(){
        return speaker+"\n"+String.valueOf(STime)+" to "+String.valueOf(ETime)+"\n"+P+"\n"+D+"\n"+subject+"\n"+String.valueOf(date);
    }
}
