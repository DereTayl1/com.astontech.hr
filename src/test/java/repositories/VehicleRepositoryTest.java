package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by deretayl1 on 4/5/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})

public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testSaveVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVIN("1C3BC1FG5BN023388\n");
        vehicle.setColor("Blue");
        vehicle.setLicensePlate("FFF-XVH");
        vehicle.setYear(1990);

        assertNull(vehicle.getId());
        vehicleRepository.save(vehicle);
        assertNotNull(vehicle.getId());

        Vehicle foundVehicle = vehicleRepository.findOne(vehicle.getId());
        assertNotNull(foundVehicle);
        assertEquals(foundVehicle.getId(), vehicle.getId());

        foundVehicle.setVIN("WA1YD54B42N014175\n");
        foundVehicle.setColor("Red");
        foundVehicle.setLicensePlate("896-XVH");
        foundVehicle.setYear(2001);

        vehicleRepository.save(foundVehicle);
        Vehicle updatedVehicle = vehicleRepository.findOne(foundVehicle.getId());
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

        vehicleRepository.save(vehicleList);

        Iterable<Vehicle> foundVehicleList = vehicleRepository.findAll();
        Integer i = 0;
        for(Vehicle vehicle : foundVehicleList) {
            i++;
        }
    }


    @Test
    public void testDeleteVehicle(){
        //CREATE A NEW ELEMENT
        Vehicle vehicle = new Vehicle();
        vehicleRepository.save(vehicle);

        //CALL METHOD TO DELETE ELEMENT
        vehicleRepository.delete(vehicle);

        //TEST WHETHER OR NOT DELETE WAS SUCCESSFUL
        assertNull(vehicleRepository.findOne(vehicle.getId()));
    }

}

