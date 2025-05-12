package com.example.smarthome.services;

import org.springframework.stereotype.Component;

@Component
public class Validation {

    public boolean validateSpeed(int speed){
        if(speed>= 0 && speed <=2) return  true;
        return false;
    }
}
