package com.example.fullstack.DataWork;

public class SaveData {
    private String data;

    public void save(String data) {
        this.data = data;
        new compareUsers(data);
    }

    public String getData() {
        return data;
    }
    //kommentar 2
}
