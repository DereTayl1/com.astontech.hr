package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by deretayl1 on 4/6/2016.
 */
public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {
    VehicleMake findByVehicleMakeName(String vehicleMakeName);

    List<VehicleMake> findAllByVehicleMakeName(String vehicleMakeName);
}
