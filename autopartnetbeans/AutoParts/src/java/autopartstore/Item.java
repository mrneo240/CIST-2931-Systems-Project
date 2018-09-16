/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

/**
 *
 * @author Hayden Kowalchuk
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

    private int ID;
    private String dept;
    private String name;
    private String desc;
    private double price;

    //Constructors
    public Item() {
        ID = 0;
        dept = "";
        desc = "";
        name = "";
        price = 0.0;
    }

    public Item(int id, String _dept, String _name, String _desc, double _price) {
        ID = id;
        dept = _dept;
        desc = _desc;
        name = _name;
        price = _price;
    }
    
    public String toString(){
        return String.format("Item[%d, %s, %s, %s, %f]", ID, dept, desc, name, price);
    }
    
    public void display(){
        System.out.println(toString());
    }

    //MAin tester
    public static void main(String[] args) {
        Item i1;
        i1 = new Item(1, "Maintenance", "Filter", "An air filter", 5.99);
        //i1.display();
    }
}
