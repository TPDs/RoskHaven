package com.company;

import java.time.LocalDateTime;

public class UserCheckInOut {
    private User user;
    private String checkInTime;
    private int checkInTimeInMins;
    private String checkOutTime;
    private int checkOutTimeInMins;
    private int totalTimeCheckedIn;

    public UserCheckInOut(User user){
        this.user = user;
        setCheckInTimeToNow();
        checkOutTime = "";
        checkOutTimeInMins = 0;
        totalTimeCheckedIn = 0;

    }

    public User getUser() {
        return user;
    }



    public void setCheckInTimeToNow(){
        LocalDateTime tempDateTime = LocalDateTime.now();
        checkInTimeInMins = tempDateTime.getHour()*60 + tempDateTime.getMinute();
        checkInTime = tempDateTime.getHour() + ":" + tempDateTime.getMinute();
    }

    public void setCustomCheckInTime(int hour, int minutes){
        checkInTimeInMins = hour*60 + minutes;
        checkInTime = "" + hour + ":" + minutes;
    }

    public void setCheckOutTimeToNow(){
        LocalDateTime tempDateTime = LocalDateTime.now();
        checkOutTimeInMins = tempDateTime.getHour()*60 + tempDateTime.getMinute();
        checkOutTime = tempDateTime.getHour() + ":" + tempDateTime.getMinute();
    }

    public void setCustomCheckOutTime(int hour, int minutes){
        checkOutTimeInMins = hour*60 + minutes;
        checkOutTime = "" + hour + ":" + minutes;
    }


    public void calcTotalTimeCheckedIn(){

        totalTimeCheckedIn = checkOutTimeInMins - checkInTimeInMins;
    }
}
