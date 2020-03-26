package com.company;

import java.time.LocalDateTime;

public class ChildCheckInOut {
    private Child child;
    private String checkInTime;
    private String checkOutTime;
    private int totalTimeCheckedIn;

    public ChildCheckInOut(Child child){
        this.child = child;
        setCheckInTimeToNow();
        checkOutTime = "";
        totalTimeCheckedIn = 0;
    }

    public Child getChild() {
        return child;
    }



    public void setCheckInTimeToNow(){
        LocalDateTime tempDateTime = LocalDateTime.now();
        checkInTime = tempDateTime.getHour() + ":" + tempDateTime.getMinute();
    }

    public void setCustomCheckInTime(int hour, int minutes){
        checkInTime = "" + hour + ":" + minutes;
    }

    public void setCheckOutTimeToNow(){
        LocalDateTime tempDateTime = LocalDateTime.now();
        checkOutTime = tempDateTime.getHour() + ":" + tempDateTime.getMinute();
    }

    public void setCustomCheckOutTime(int hour, int minutes){
        checkOutTime = "" + hour + ":" + minutes;
    }




    public void calcTotalTimeCheckedIn(){
        int checkInInMinutes = (Integer.parseInt(checkInTime.substring(0,2))*60)+(Integer.parseInt(checkInTime.substring(3)));
        int checkOutInMinutes = (Integer.parseInt(checkOutTime.substring(0,2))*60)+(Integer.parseInt(checkOutTime.substring(3)));
        totalTimeCheckedIn = checkOutInMinutes-checkInInMinutes;
    }
}
