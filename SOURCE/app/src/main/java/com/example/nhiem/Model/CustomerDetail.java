package com.example.nhiem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerDetail {

    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("point")
    @Expose
    private Integer point;
    @SerializedName("isNeedUpate")
    @Expose
    private Integer isNeedUpate;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getIsNeeUpate() {
        return isNeedUpate;
    }

    public void setIsNeeUpate(Integer isNeeUpate) {
        this.isNeedUpate = isNeeUpate;
    }

}