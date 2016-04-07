package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.services.VehicleMakeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by deretayl1 on 4/6/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleMakeServiceTest {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Test
    public void testSaveVehicleMake(){
        VehicleMake vehicleMake = new VehicleMake();

        vehicleMake.setVehicleMakeName("Toyota");

        vehicleMakeService.saveVehicleMake(vehicleMake);
        assertNotNull(vehicleMake);


        VehicleMake fetchedMake = vehicleMakeService.getVehicleMakeById(vehicleMake.getId());
        assertEquals(fetchedMake.getId(), vehicleMake.getId());


        fetchedMake.setVehicleMakeName("Chevy");
        vehicleMakeService.saveVehicleMake(fetchedMake);

        VehicleMake updatedMake = vehicleMakeService.getVehicleMakeById(fetchedMake.getId());
        assertEquals(updatedMake.getVehicleMakeName(), "Chevy");

    }

    @Test
    public void testSaveVehicleMakeList(){

        List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();

        vehicleMakeList.add(new VehicleMake("Chevy"));
        vehicleMakeList.add(new VehicleMake("Ford"));
        vehicleMakeList.add(new VehicleMake("Toyota"));
        vehicleMakeList.add(new VehicleMake("Nissan"));

        vehicleMakeService.saveVehicleMakeList(vehicleMakeList);

        Integer i = 0;
        for(VehicleMake vehicleMake : vehicleMakeList){
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void testFindByVehicleMake(){

        VehicleMake vehicleMake = new VehicleMake("Toyota");

        vehicleMakeService.saveVehicleMake(vehicleMake);

        VehicleMake foundMake = vehicleMakeService.getVehicleMakeById(vehicleMake.getId());
        assertEquals(foundMake.getId(), vehicleMake.getId());


    }
}

