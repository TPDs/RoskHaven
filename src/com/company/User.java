package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class User implements ClassesToStoreInFiles{
    private String name;
    private String CPR;
    private String password;

    public User(String name, String CPR, String password){
        this.name = name;
        this.CPR = CPR;
        this.password = password;
    }

    public boolean login(String password){
        return password.equals(this.password);
    }

    public String getCPR() {
        return CPR;
    }
    

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.CPR = id;
    }

    //.equals is auto-generated by IntelliJ, might need to be changed later.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return CPR.equals(user.CPR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPR);
    }

    @Override
    public void writeToFile(){
    String StringToFile =  this.name + " " + this.CPR + " " + this.password;
        try {
            FileWriter Userfw = new FileWriter("src/resourser/EmployeeListFile");
            Userfw.write(StringToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", CPR='" + CPR + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
