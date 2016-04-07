package com.astontech.hr.domain.VO;

/**
 * Created by deretayl1 on 4/4/2016.
 */
public class ElementVO {

    private String newElementType;
    private String newElements;
    private String[] newElementArray;

    public ElementVO() {}


    public String getNewElementType() {
        return newElementType;
    }

    // region CUSTOM METHODS
    public void splitNewElementsIntoArray() {

        //notes: REGEX FOR SPLITTING ON A NEW LINE OR CARRAGE RETURN IS "\\r?\\n"
        this.setNewElementArray(this.newElements.split("\\r?\\n"));
    }
    // endregion

    // region GET & SET
    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }
    // endregion


}
