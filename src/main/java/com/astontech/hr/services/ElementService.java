package com.astontech.hr.services;

import com.astontech.hr.domain.Element;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by deretayl1 on 4/1/2016.
 */
@Service
public interface ElementService {

    Iterable<Element> elementListAll();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

    //CUSTOM REPOSITORY METHODS
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllbyElementNameIgnoreCase(String elementName);

}
