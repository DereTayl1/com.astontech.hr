package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by deretayl1 on 4/5/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Vehicle findVehicleByYear(Integer year);


}
