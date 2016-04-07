package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by deretayl1 on 4/6/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleModelServiceTest {

    @Autowired
    private VehicleModelService vehicleModelService;

    @Test
    public void testSaveVehicleModel(){
        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleModelName("Toyota");

        vehicleModelService.saveVehicleModel(vehicleModel);
        assertNotNull(vehicleModel);


        VehicleModel fetchedModel = vehicleModelService.getVehicleModelById(vehicleModel.getId());
        assertEquals(fetchedModel.getId(), vehicleModel.getId());


        fetchedModel.setVehicleModelName("Chevy");
        vehicleModelService.saveVehicleModel(fetchedModel);

        VehicleModel updatedModel = vehicleModelService.getVehicleModelById(fetchedModel.getId());
        assertEquals(updatedModel.getVehicleModelName(), "Chevy");

    }

    @Test
    public void testSaveVehicleModelList(){

        List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();

        vehicleModelList.add(new VehicleModel("Chevy"));
        vehicleModelList.add(new VehicleModel("Ford"));
        vehicleModelList.add(new VehicleModel("Toyota"));
        vehicleModelList.add(new VehicleModel("Nissan"));

        vehicleModelService.saveVehicleModelList(vehicleModelList);

        Integer i = 0;
        for(VehicleModel vehicleModel : vehicleModelList){
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void testFindByVehicleModel(){

        VehicleModel vehicleModel = new VehicleModel("Toyota");

        vehicleModelService.saveVehicleModel(vehicleModel);

        VehicleModel foundModel = vehicleModelService.getVehicleModelById(vehicleModel.getId());
        assertEquals(foundModel.getId(), vehicleModel.getId());


    }
}
