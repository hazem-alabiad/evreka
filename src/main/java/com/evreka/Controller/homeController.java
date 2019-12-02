package com.evreka.Controller;

import com.evreka.Entity.NavigationRecord;
import com.evreka.Entity.Vehicle;
import com.evreka.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class homeController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<NavigationRecord> navigationRecords = new ArrayList<>();
        vehicles.forEach(v -> navigationRecords.addAll(v.getNavigationRecords()));

        List<NavigationRecord> validNavigationRecords =  navigationRecords.stream().filter(NavigationRecord::isLastTwoDays).collect(Collectors.toList());

        Map<String, Object> params = new HashMap<>();
        params.put("navRecords", validNavigationRecords);

        return new ModelAndView("home", params);
    }

}
