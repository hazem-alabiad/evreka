package com.evreka.Controller;

import com.evreka.Entity.Vehicle;
import com.evreka.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicle(@PathVariable long id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {
        vehicleService.updateVehicle(vehicle, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
    }
}
