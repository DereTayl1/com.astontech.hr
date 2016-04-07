package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.stereotype.Service;

/**
 * Created by deretayl1 on 4/6/2016.
 */
@Service
public interface VehicleMakeService {

    Iterable<VehicleMake> vehicleMakeListAll();

    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicle(Integer id);

}
