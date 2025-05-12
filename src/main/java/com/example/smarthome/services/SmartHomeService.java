package com.example.smarthome.services;

import com.example.smarthome.Excptions.ValidationException;
import com.example.smarthome.dto.AirCondition;
import com.example.smarthome.dto.Fan;
import com.example.smarthome.dto.Light;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmartHomeService {

    private final Validation validation;
    private final Logger logger = LoggerFactory.getLogger(SmartHomeService.class);

    public SmartHomeService(Validation validation) {
        this.validation = validation;
    }

    public boolean setLight(boolean action) {
        logger.info("setLight");
        Light light = new Light();
        light.setOff(action);
        // call the light api
        RestTemplate restTemplate = new RestTemplate();
        var result  = restTemplate.postForObject("http://light.api/call", light, Light.class);
        return result.isOff();
    }
    public void setFan(int speed) {
        if(validation.validateSpeed(speed)) {
            logger.info("setFan");
            var fan = new Fan();
            fan.setSpeed(speed);
            //call the fan api
        } else {
            logger.error("Error isn setFan with speed:{}", speed);
            throw new ValidationException("Speed is not valid");
        }
    }

    public  void setAirCondition(int temp) {
        logger.info("setAirCondition");
        var airCondition = new AirCondition();
        airCondition.setTemperature(temp);
        // call the air condition api
    }

}
