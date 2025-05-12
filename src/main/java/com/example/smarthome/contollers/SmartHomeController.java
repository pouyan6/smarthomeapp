package com.example.smarthome.contollers;

import com.example.smarthome.services.SmartHomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("smart")
public class SmartHomeController {

    private final SmartHomeService smartHomeService;

    public SmartHomeController(SmartHomeService smartHomeService) {
        this.smartHomeService = smartHomeService;
    }

    @PostMapping("/light")
    public void setLight(@RequestParam("action") boolean action){
        smartHomeService.setLight(action);
    }

    @PostMapping("/fan")
    public void setFan(@RequestBody int speed){
        smartHomeService.setFan(speed);
    }

    @PostMapping("/air_condition")
    public void setAirCondition(@RequestBody int temp){
        smartHomeService.setAirCondition(temp);
    }
}
