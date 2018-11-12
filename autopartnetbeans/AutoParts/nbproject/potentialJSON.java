-----------------------------------autopartsstore.Item.java-----------------------------------

package autopartsstore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

@SerializedName("itemID")
@Expose
private String itemID;
@SerializedName("qty")
@Expose
private Integer qty;

public String getItemID() {
return itemID;
}

public void setItemID(String itemID) {
this.itemID = itemID;
}

public Integer getQty() {
return qty;
}

public void setQty(Integer qty) {
this.qty = qty;
}

}
-----------------------------------autopartsstore.Order.java-----------------------------------

package autopartsstore;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

@SerializedName("orderNo")
@Expose
private Integer orderNo;
@SerializedName("customerID")
@Expose
private Integer customerID;
@SerializedName("items")
@Expose
private List<Item> items = null;
@SerializedName("status")
@Expose
private Integer status;
@SerializedName("date")
@Expose
private String date;

public Integer getOrderNo() {
return orderNo;
}

public void setOrderNo(Integer orderNo) {
this.orderNo = orderNo;
}

public Integer getCustomerID() {
return customerID;
}

public void setCustomerID(Integer customerID) {
this.customerID = customerID;
}

public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

}