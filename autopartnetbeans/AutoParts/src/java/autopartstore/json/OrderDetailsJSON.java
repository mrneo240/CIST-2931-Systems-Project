/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Hayden Kowalchuk
 */
public class OrderDetailsJSON {

    @SerializedName("name")
    @Expose
    public String name = "";

    @SerializedName("addr")
    @Expose
    public String address = "";
    
    public String getAddress(){
        return address;
    }

    @SerializedName("CC")
    @Expose
    public String creditCard = "";

    public void synchronize() {

    }

    public void getDetails() {
        synchronize();
    }

}
