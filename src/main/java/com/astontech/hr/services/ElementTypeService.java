package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by deretayl1 on 4/2/2016.
*/
@Service
public interface ElementTypeService {

    Iterable<ElementType> elementTypeListAll();

    ElementType getElementTypeById(Integer Id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    //CUSTOM REPOSITORY METHODS
    ElementType findByElementTypeName(String elementTypeName);


}
