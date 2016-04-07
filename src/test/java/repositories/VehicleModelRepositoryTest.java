package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by deretayl1 on 4/6/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})

public class VehicleModelRepositoryTest {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Test
    public void testSaveVehicleModel(){
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelName("Rav4");

        vehicleModelRepository.save(vehicleModel);
        assertNotNull(vehicleModel);

        VehicleModel fetchModel = vehicleModelRepository.findOne(vehicleModel.getId());
        assertEquals(fetchModel.getId(), vehicleModel.getId());

        fetchModel.setVehicleModelName("Camry");
        vehicleModelRepository.save(fetchModel);

        VehicleModel updatedModel = vehicleModelRepository.findOne(fetchModel.getId());
        assertEquals(updatedModel.getVehicleModelName(), "Camry");
    }

}

