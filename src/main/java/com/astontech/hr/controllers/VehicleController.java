package com.astontech.hr.controllers;


import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by deretayl1 on 4/6/2016.
 */
@Controller
@RequestMapping(value = "/admin/vehicle")
public class VehicleController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @RequestMapping(value = "/make", method = RequestMethod.GET)
    public String adminVehicleMakeGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleMakeList", vehicleMakeService.vehicleMakeListAll());
        return "admin/vehicle/vehicle_make";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String adminVehicleModelGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        return "admin/vehicle/vehicle_model";
    }

    @RequestMapping(value = "/make", method = RequestMethod.POST)
    public String adminVehicleMakeGet(VehicleVO vehicleVO, Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleMakeList", vehicleMakeService.vehicleMakeListAll());
        return "admin/vehicle/vehicle_make";
    }

}







