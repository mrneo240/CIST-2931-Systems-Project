/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 Advance Projects
Auto Parts Store 
 */
public class addressJSON {

    @SerializedName("street")
    @Expose
    private String street;
    
    @SerializedName("city")
    @Expose
    private String city;
    
    @SerializedName("state")
    @Expose
    private String state;
    
    @SerializedName("zipcode")
    @Expose
    private String zip;

    public addressJSON() {
        street = "";
        city = "";
        state = "";
        zip = "";
    }

    public addressJSON(String st, String ct, String ste, String zp) {
        street = st;
        city = ct;
        state = ste;
        zip = zp;
    }

    public void setstreet(String st) {
        street = st;
    }

    public String getstreet() {
        return street;
    }

    public void setcity(String ct) {
        city = ct;
    }

    public String getcity() {
        return city;
    }

    public void setstate(String ste) {
        state = ste;
    }

    public String getstate() {
        return state;
    }

    public void setzip(String zp) {
        zip = zp;
    }

    public String getzip() {
        return zip;
    }

    public void display() {
        System.out.println("Street = " + getstreet());
        System.out.println("City = " + getcity());
        System.out.println("State = " + getstate());
        System.out.println("Zip = " + getzip());

    }

    public String toString() {
        return String.format("%s %s, %s %s", getstreet(), getcity(), getstate(), getzip());
    }

    public static void main(String[] args) {
        addressJSON a1 = new addressJSON("167 timber st", "atlanta", "ga", "11342");
        a1.display();
    }
}
