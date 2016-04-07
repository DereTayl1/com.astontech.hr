package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
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
 * Created by deretayl1 on 4/1/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;

    @Test
    public void testSaveElement() {

        //setup element
        Element element = new Element("ServiceTest");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementService.saveElement(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementService.getElementById(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementService.saveElement(fetchedElement);

        Element updatedElement = elementService.getElementById(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");

    }

    @Test
    public void testSaveElementList(){

        //CREATE NEW LIST
        List<Element> elementList = new ArrayList<>();
        //ADD ELEMENTS TO THE LIST
        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementService.saveElementList(elementList);

    }

    @Test
    public void testFindByName(){

        Element element = new Element("FindTest");
        elementService.saveElement(element);

        Element foundByNameElement = elementService.findByElementName("FindTest");

        assertEquals(element.getId(), foundByNameElement.getId());

    }

    @Test
    public void testFindAllByName(){

        Element element1 = new Element("FindListTest");
        elementService.saveElement(element1);
        Element element2 = new Element("FindListTest");
        elementService.saveElement(element2);
        Element element3 = new Element("FindListTest");
        elementService.saveElement(element3);

        List<Element> foundAllByNameElement = elementService.findAllByElementName("FindListTest");

        assertEquals(3, foundAllByNameElement.size());
    }

    @Test
    public void testDeleteElement(){
        //CREATE A NEW ELEMENT
        Element element = new Element();
        elementService.saveElement(element);

        //CALL METHOD TO DELETE ELEMENT
        elementService.deleteElement(element.getId());

        //TEST WHETHER OR NOT DELETE WAS SUCCESSFUL
        assertNull(elementService.findByElementName("deleteMe"));
    }

}

