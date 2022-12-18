
package com.model;


public class Invoice {
    private int No;
    private String date;
    private String customerName;
    

    public Invoice() {
    }

    public Invoice(int No, String date, String customerName) {
        this.No = No;
        this.date = date;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
    
}
