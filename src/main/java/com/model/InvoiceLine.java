
package com.model;



public class InvoiceLine {
    private int lineNo;
    private String Itemname;
    private double Itemprice;
    private int count;
    private Invoice Num;

    public InvoiceLine() {
    }

    public InvoiceLine(int lineNo, String Itemname, double Itemprice, int count) {
        this.lineNo = lineNo;
        this.Itemname = Itemname;
        this.Itemprice = Itemprice;
        this.count = count;
    }

    public InvoiceLine(int lineNo, String Itemname, double Itemprice, int count, Invoice Num) {
        this.lineNo = lineNo;
        this.Itemname = Itemname;
        this.Itemprice = Itemprice;
        this.count = count;
        this.Num = Num;
    }
    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String Itemname) {
        this.Itemname = Itemname;
    }

    public double getItemprice() {
        return Itemprice;
    }

    public void setItemprice(double Itemprice) {
        this.Itemprice = Itemprice;
    }
    
    
    
}
