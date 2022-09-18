package com.kakaomaptest.kakaomap.controller;


import com.kakaomaptest.kakaomap.Entity.Location;
import com.kakaomaptest.kakaomap.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressController {

        @Autowired
        LocationRepository locationRepository;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String locationData(String lati, String logi){


            Location location = new Location();
            location.setLati(lati);
            location.setLogi(logi);
            locationRepository.save(location);

            return "address";
        }



}
