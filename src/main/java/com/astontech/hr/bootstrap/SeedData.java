package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
* Created by deretayl1 on 4/2/2016.
*/
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        generateElementAndElementTypes();

        generateVehicleMake();

    }

    private void generateVehicleMake(){

        List<VehicleMake> makeList = new ArrayList<>();

        makeList.add(new VehicleMake("Toyota"));
        makeList.add(new VehicleMake("Nissan"));
        makeList.add(new VehicleMake("Chevy"));
        makeList.add(new VehicleMake("Ford"));
        makeList.add(new VehicleMake("Dodge"));

        vehicleMakeService.saveVehicleMakeList(makeList);

    }

    private void generateElementAndElementTypes() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> laptopList = new ArrayList<>();

        laptopList.add(new Element("Apple"));
        laptopList.add(new Element("Acer"));
        laptopList.add(new Element("Asus"));
        laptopList.add(new Element("Dell"));
        laptopList.add(new Element("HP"));
        laptopList.add(new Element("Samsung"));

        laptopType.setElementList(laptopList);

        elementTypeService.saveElementType(laptopType);


        ElementType phoneType = new ElementType("Phone");

        List<Element> phoneList = new ArrayList<>();

        phoneList.add(new Element("Apple"));
        phoneList.add(new Element("Samsung"));
        phoneList.add(new Element("Nokia"));
        phoneList.add(new Element("ZTE"));
        phoneList.add(new Element("Google"));
        phoneList.add(new Element("Windows"));

        phoneType.setElementList(phoneList);

        elementTypeService.saveElementType(phoneType);



        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();

        emailList.add(new Element("Work"));
        emailList.add(new Element("AOL"));
        emailList.add(new Element("Gmail"));
        emailList.add(new Element("Yahoo"));
        emailList.add(new Element("Outlook"));
        emailList.add(new Element("iCloud"));

        emailType.setElementList(emailList);

        elementTypeService.saveElementType(emailType);
    }

}
