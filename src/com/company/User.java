package com.company;

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
    public void writeToFile() {

    }
}
