package com.example.fullstack.DataWork;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class compareUsers {

    String inputUser;



    public compareUsers(String inputUser) {
        this.inputUser = inputUser;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse den JSON-String in ein User-Objekt
            userJson user = objectMapper.readValue(inputUser, userJson.class);
            System.out.println("Name: "+user.getName());
            System.out.println("E-Mail: "+user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void saveUserAsJson() {

    }

    private void doesUserExists() {

    }


}
