package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by deretayl1 on 4/1/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {
    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {

        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
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
        //SAVE LIST TO THE REPOSITORY
        elementRepository.save(elementList);
        //GETS THE LIST FROM THE REPOSITORY
        Iterable<Element> fetchedElementList = elementRepository.findAll();
        //ITTERATES THROUGH THE LIST, COUNTS UP AND PRINTS
        int count = 0;
        for(Element element : fetchedElementList) {
            count = count++;        }

//        assertEquals(5, count);
    }

    @Test
    public void testFindByName(){

        Element element = new Element("FindTest");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTest");

        assertEquals(element.getId(), foundByNameElement.getId());

    }

    @Test
    public void testFindAllByName(){

        Element element1 = new Element("FindListTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindListTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindListTest");
        elementRepository.save(element3);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindListTest");

        assertEquals(3, foundAllByNameElement.size());
    }

    @Test
    public void testDeleteElement(){
        //CREATE A NEW ELEMENT
        Element element = new Element();
        elementRepository.save(element);

        //CALL METHOD TO DELETE ELEMENT
        elementRepository.delete(element);

        //TEST WHETHER OR NOT DELETE WAS SUCCESSFUL
        assertNull(elementRepository.findByElementName("deleteMe"));
    }
}


