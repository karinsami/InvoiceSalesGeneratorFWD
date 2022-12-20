
package com.model;



public class InvoiceLine {
    private int lineNo;
    private String itemName;
    private double itemPrice;
    private int itemCount;
    private Invoice num;

    public InvoiceLine() {
    }


    public InvoiceLine(int lineNo, String itemName, double itemPrice, int itemCount, Invoice num) {
        this.lineNo = lineNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.num = num;
    }
    
    public double calculateItemTotal(){
        
        System.out.println(this.itemCount);
        System.out.println( itemPrice);
        return itemPrice*itemCount;
       
    }

    public int getitemCount() {
        return itemCount;
    }

    public void setitemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public double getitemPrice() {
        return itemPrice;
    }

    public void setitemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    
    
}
