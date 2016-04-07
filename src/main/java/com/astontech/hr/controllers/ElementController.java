package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.services.ElementTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deretayl1 on 4/4/2016.
 */
@Controller
//test
public class ElementController {

    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public  String adminHome() {

        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model) {
        elementVO.splitNewElementsIntoArray();
        logElementVo(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("dangerAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {

        model.addAttribute("elementTypeList", elementTypeService.elementTypeListAll());

        return "admin/element/element_list";
    }


    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {

        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list/";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {

        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam ("inputNewElement") String newElement) {

        //notes: if newElement (unbound text box) has a value, add it to the list
        if(!newElement.equals("")) {
            elementType.getElementList().add(new Element(newElement));
        }

        //notes: ITERATE THROUGH THE LIST OF ELEMENTS
        for(int i = 0; i < elementType.getElementList().size(); i++){
            //notes: CHECK TO SEE IF ELEMENT NAME IS EMPTY
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                //notes: ELEMENT NAME IS BLANK REMOVE IT FROM THE LIST:
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementType(elementType);

        return "redirect:/admin/element/edit/" + elementType.getId();

    }

    // region HELPER METHODS
    private void saveElementTypeAndElementsFromVO(ElementVO elementVo){
        //CREATE A NEW LIST OF ELEMENTS
        List<Element> newElementList = new ArrayList<>();

        //ITERATE THROUGH THE LIST AND
        for(String str : elementVo.getNewElementArray()) {
            //ADD EACH STRING IN VIEW OBJECT INTO NEW LIST
            newElementList.add(new Element(str));
        }

        //CREATE NEW ELEMENT TYPE FROM THE VIEW OBJECT
        ElementType newElementType = new ElementType(elementVo.getNewElementType());

        //SET THE NEW ELEMENT LIST INTO THE NEW ELEMENT TYPE
        newElementType.setElementList(newElementList);

        //SAVE THE NEW ELEMENT TYPE WITH LIST SUB OBJECT INTO THE ELEMENT_TYPE SERVICE OBJECT
        elementTypeService.saveElementType(newElementType);

    }
    private void logElementVo(ElementVO elementVO){
        log.info("New Element Type: " + elementVO.getNewElementType());


        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }
    }
    // endregion


}
