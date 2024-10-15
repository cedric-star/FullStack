package com.example.fullstack.controller;
import com.example.fullstack.DataWork.SaveData;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(MappingProvider.BASE_PATH)
public class MessageController {

    private final SaveData saveData;

    public MessageController() {
        this.saveData = new SaveData();
    }

    @GetMapping("/error")
    public String error() {
        return "/error nachhircht in messagecontroller";
    }


    @PostMapping("/getuserdata")
    public String getUserData(@RequestBody String userData) {
        saveData.save(userData);
        return "/getUserData methode";
    }
}




