package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by deretayl1 on 4/6/2016.
 */
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    VehicleModel findByVehicleModelName(String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelName(String vehicleModelName);

}
