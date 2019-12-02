package com.evreka.Service;

import com.evreka.Entity.Vehicle;
import com.evreka.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepo.findAll().forEach(vehicles::add);
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
    }

    public Vehicle getVehicle(long id){
        return vehicleRepo.findById(id).orElseThrow(NullPointerException::new);
    }

    public void updateVehicle(Vehicle newVehicle, long id) {
        Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(NullPointerException::new);
        if(newVehicle.getPlate() != null)
            vehicle.setPlate(newVehicle.getPlate());
        vehicleRepo.save(vehicle);
    }

    public void deleteVehicle(long id) {
        vehicleRepo.deleteById(id);
    }
}
