package com.evreka.Repository;

import com.evreka.Entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<Vehicle, Long> {
}
