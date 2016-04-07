package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;
import org.springframework.stereotype.Service;

/**
 * Created by deretayl1 on 4/6/2016.
 */
@Service
public interface VehicleService {

    Iterable<Vehicle> vehicleListAll();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

}
