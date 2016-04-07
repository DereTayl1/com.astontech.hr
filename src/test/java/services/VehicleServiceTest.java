package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.services.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by deretayl1 on 4/6/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleServiceTest {
    @Autowired
    private VehicleService vehicleService;

    @Test
    public void testSaveVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVIN("1C3BC1FG5BN023388\n");
        vehicle.setColor("Blue");
        vehicle.setLicensePlate("FFF-XVH");
        vehicle.setYear(1990);

        assertNull(vehicle.getId());
        vehicleService.saveVehicle(vehicle);
        assertNotNull(vehicle.getId());

        Vehicle foundVehicle = vehicleService.getVehicleById(vehicle.getId());
        assertNotNull(foundVehicle);
        assertEquals(foundVehicle.getId(), vehicle.getId());

        foundVehicle.setVIN("WA1YD54B42N014175\n");
        foundVehicle.setColor("Red");
        foundVehicle.setLicensePlate("896-XVH");
        foundVehicle.setYear(2001);

        vehicleService.saveVehicle(foundVehicle);
        Vehicle updatedVehicle = vehicleService.getVehicleById(foundVehicle.getId());
        assertEquals(updatedVehicle.getId(), foundVehicle.getId());

    }

    @Test
    public void testSaveVehicleList(){
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(new Vehicle(2006, "XVV-541", "JH2RD020XJK048045","Red"));
        vehicleList.add(new Vehicle(2001, "FDE-486", "1B7HF16Z2TS783585","Navy"));
        vehicleList.add(new Vehicle(1998, "DFE-457", "JS2RC41H335248346","Black"));
        vehicleList.add(new Vehicle(2012, "SDW-655", "1G3AM47A1ER389720","White"));
        vehicleList.add(new Vehicle(2015, "GGG-854", "1FUJGNDR2DDF60764","Beige"));

        vehicleService.saveVehicleList(vehicleList);

        Iterable<Vehicle> foundVehicleList = vehicleService.vehicleListAll();
        Integer i = 0;
        for(Vehicle vehicle : foundVehicleList) {
            i++;
        }
    }

    @Test
    public void testDeleteVehicle(){
        //CREATE A NEW ELEMENT
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicleService.saveVehicle(vehicle);

        //CALL METHOD TO DELETE ELEMENT
        vehicleService.deleteVehicle(1);

        //TEST WHETHER OR NOT DELETE WAS SUCCESSFUL
        assertNull(vehicleService.getVehicleById(1));
    }

}

