package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by deretayl1 on 4/2/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementTypeServiceTest {

    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void testSaveElementType(){

        //setup element
        ElementType element = new ElementType("ServiceTest");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementTypeService.saveElementType(element);
        assertNotNull(element.getId());

        //fetch
        ElementType fetchedElementType = elementTypeService.getElementTypeById(element.getId());
        assertNotNull(fetchedElementType);
        assertEquals(element.getId(), fetchedElementType.getId());

        //update
        fetchedElementType.setElementTypeName("Email");
        elementTypeService.saveElementType(fetchedElementType);

        ElementType updatedElementType = elementTypeService.getElementTypeById(fetchedElementType.getId());

        assertEquals(updatedElementType.getElementTypeName(), "Email");
    }

}

