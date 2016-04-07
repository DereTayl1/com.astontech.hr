package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by deretayl1 on 4/1/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})

public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testSaveElementType() {

        //setup element
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Phone");

        //save elementType, verify it has an ID after the save
        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        //fetch
        ElementType fetchedElementType = elementTypeRepository.findOne(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        //update
        fetchedElementType.setElementTypeName("Email");
        elementTypeRepository.save(fetchedElementType);

        ElementType updatedElementType = elementTypeRepository.findOne(fetchedElementType.getId());
        assertEquals(updatedElementType.getElementTypeName(), "Email");

    }

    @Test
    public void testSaveElementTypeList(){
        //CREATE NEW LIST
        List<ElementType> elementTypeList = new ArrayList<>();
        //ADD ELEMENTS TO THE LIST
        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("Email"));
        elementTypeList.add(new ElementType("Laptop"));
        elementTypeList.add(new ElementType("PayRate"));
        //SAVE LIST TO THE REPOSITORY
        elementTypeRepository.save(elementTypeList);
        //GETS THE LIST FROM THE REPOSITORY
        Iterable<ElementType> fetchedElementTypeList = elementTypeRepository.findAll();
        //ITTERATES THROUGH THE LIST, COUNTS UP AND PRINTS
        int count = 0;
        for(ElementType elementType : fetchedElementTypeList) {
            count = count++;        }

//        assertEquals(5, count);
    }

    @Test
    public void testFindByName(){

        ElementType elementType = new ElementType("FindTest");
        elementTypeRepository.save(elementType);

        ElementType foundByNameElementType = elementTypeRepository.findByElementTypeName("FindTest");

        assertEquals(elementType.getId(), foundByNameElementType.getId());

    }

    @Test
    public void testDeleteElementType(){
        //CREATE A NEW ELEMENT
        ElementType elementType = new ElementType();
        elementTypeRepository.save(elementType);

        //CALL METHOD TO DELETE ELEMENT
        elementTypeRepository.delete(elementType);

        //TEST WHETHER OR NOT DELETE WAS SUCCESSFUL
        assertNull(elementTypeRepository.findByElementTypeName("deleteMe"));
    }


}

