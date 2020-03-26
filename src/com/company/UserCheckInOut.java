package com.company;

import java.time.LocalDateTime;

public class UserCheckInOut {
    private User user;
    private String checkInTime;
    private String checkOutTime;
    private int totalTimeCheckedIn;

    public UserCheckInOut(User user){
        this.user = user;
        checkInTime = "";
        checkOutTime = "";
        totalTimeCheckedIn = 0;
    }

    public User getUser() {
        return user;
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
