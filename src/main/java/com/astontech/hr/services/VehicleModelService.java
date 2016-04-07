package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.stereotype.Service;

/**
 * Created by deretayl1 on 4/6/2016.
 */
@Service
public interface VehicleModelService {

    Iterable<VehicleModel> vehicleModelListAll();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicle(Integer id);

}
