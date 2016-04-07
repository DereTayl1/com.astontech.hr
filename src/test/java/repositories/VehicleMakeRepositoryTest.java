package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by deretayl1 on 4/6/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})

public class VehicleMakeRepositoryTest {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Test
    public void testSaveVehicleMake(){
        VehicleMake vehicleMake = new VehicleMake();

        vehicleMake.setVehicleMakeName("Toyota");

        vehicleMakeRepository.save(vehicleMake);
        assertNotNull(vehicleMake);


        VehicleMake fetchedMake = vehicleMakeRepository.findOne(vehicleMake.getId());
        assertEquals(fetchedMake.getId(), vehicleMake.getId());


        fetchedMake.setVehicleMakeName("Chevy");
        vehicleMakeRepository.save(fetchedMake);

        VehicleMake updatedMake = vehicleMakeRepository.findOne(fetchedMake.getId());
        assertEquals(updatedMake.getVehicleMakeName(), "Chevy");

    }

    @Test
    public void testSaveVehicleMakeList(){

        List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();

        vehicleMakeList.add(new VehicleMake("Chevy"));
        vehicleMakeList.add(new VehicleMake("Ford"));
        vehicleMakeList.add(new VehicleMake("Toyota"));
        vehicleMakeList.add(new VehicleMake("Nissan"));

        vehicleMakeRepository.save(vehicleMakeList);

        Integer i = 0;
        for(VehicleMake vehicleMake : vehicleMakeList){
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void testFindByVehicleMake(){

        VehicleMake vehicleMake = new VehicleMake("Toyota");

        vehicleMakeRepository.save(vehicleMake);

        VehicleMake foundMake = vehicleMakeRepository.findOne(vehicleMake.getId());
        assertEquals(foundMake.getId(), vehicleMake.getId());


    }

}

