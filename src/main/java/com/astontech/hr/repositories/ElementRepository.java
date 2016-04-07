package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by deretayl1 on 4/1/2016.
 */
public interface ElementRepository extends CrudRepository<Element, Integer> {

    //WILL AUTO GENERATE REQUIRED CODE FROM THE STRUCTURE OF THE METHOD NAME
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);



}
