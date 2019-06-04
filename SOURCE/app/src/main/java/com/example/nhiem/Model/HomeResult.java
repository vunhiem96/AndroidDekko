package com.example.nhiem.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResult {

@SerializedName("customerDetail")
@Expose
private CustomerDetail customerDetail;
@SerializedName("listNews")
@Expose
private List<News> listNews = null;
@SerializedName("listPromotion")
@Expose
private List<ListPromotion> listPromotion = null;

public CustomerDetail getCustomerDetail() {
return customerDetail;
}

public void setCustomerDetail(CustomerDetail customerDetail) {
this.customerDetail = customerDetail;
}

public List<News> getListNews() {
return listNews;
}

public void setListNews(List<News> listNews) {
this.listNews = listNews;
}

public List<ListPromotion> getListPromotion() {
return listPromotion;
}

public void setListPromotion(List<ListPromotion> listPromotion) {
this.listPromotion = listPromotion;
}

}