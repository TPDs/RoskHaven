package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class User implements ClassesToStoreInFiles{
    private String name;
    private String id;
    private String password;

    public User(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public boolean login(String password){
        return password.equals(this.password);
    }

    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void writeToFile(){
    String StringToFile =  this.name + " " + this.id + " " + this.password;
        try {
            FileWriter Userfw = new FileWriter("src/resourser/EmployeeListFile");
            Userfw.write(StringToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
