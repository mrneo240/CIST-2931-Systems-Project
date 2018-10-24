/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    @Override
    public String toString() {
        return String.format("%s %s, %s %s", getstreet(), getcity(), getstate(), getzip());
    }

    public static void main(String[] args) {
        addressJSON a1 = new addressJSON("167 timber st", "atlanta", "ga", "11342");
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        
        //a1.display();
        System.out.println(gson.toJson(a1));
    }
}
