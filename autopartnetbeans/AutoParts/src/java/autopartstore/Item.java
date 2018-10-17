/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Hayden Kowalchuk
 * @author Levi Llewellyn
 */
public class Item implements java.io.Serializable {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getphoto(){
        return photo;
    }
    
    public void setphoto(String photo){
        this.photo = photo;
    }

    @Expose(serialize = false)
    private int ID;

    @SerializedName("itemID")
    @Expose
    private String partCode;

    @Expose(serialize = false)
    private String dept;

    @Expose(serialize = false)
    private String name;

    @Expose(serialize = false)
    private String desc;

    @Expose(serialize = false)
    private double price;
    
    @Expose(serialize = false)
    private String photo;

    /**
     * Michelle adding the quantity of items and total cost properties for Shopping Cart
     */
    @SerializedName("qty")
    @Expose
    private int quantity;

    /**
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set the quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return getPrice() * getQuantity();
    }

    //Constructors
    public Item() {
        ID = 0;
        dept = "";
        desc = "";
        name = "";
        price = 0.0;
        partCode = "";
        quantity = 0;
    }

    public Item(int id, String _dept, String _name, String _desc, double _price, int _quantity, String code) {
        ID = id;
        dept = _dept;
        desc = _desc;
        name = _name;
        price = _price;
        partCode = code;
        quantity = _quantity;
    }

    @Override
    public String toString() {
        return String.format("Item[%d, %s, %s, %s, %s, %f]", ID, partCode, dept, desc, name, price, quantity, getTotalPrice());
    }

    public void display() {
        System.out.println(toString());
    }

    /**
     * @return the partCode
     */
    public String getPartCode() {
        return partCode;
    }

    /**
     * @param partCode the partCode to set
     */
    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

}
