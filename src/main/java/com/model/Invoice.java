
package com.model;

import java.util.ArrayList;


public class Invoice {
    private int invoiceNo;
    private String date;
    private String customerName;
    private ArrayList<InvoiceLine> lines;
    private double invoiceTotal;
    private static int count = 0;

    public double getInvoiceTotal() {
        return invoiceTotal;
    }
    
    
    
     
    

    public Invoice() {
    }

    public Invoice(int invoiceNo, String date, String customerName) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.customerName = customerName;
        this.invoiceTotal = 0.0;
        this.count++;
    }
    public Invoice(String date, String customerName) {
        this.count++;
        this.invoiceNo = count;
        this.date = date;
        this.customerName = customerName;
        this.invoiceTotal = 0.0;
        
    }
    public double calculateInvoiceTotal(){
        
        this.invoiceTotal = 0.0;
        for (InvoiceLine line : getLines()){
            invoiceTotal += line.calculateItemTotal();
            System.out.println("invoiceTotal" + invoiceTotal);
        }
   
    return invoiceTotal;
}
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getinvoiceNo() {
        return invoiceNo;
    }

   
    public void setivoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

       public ArrayList<InvoiceLine> getLines(){
        if(lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getCSVFormat(){
        return invoiceNo+","+date+","+customerName;
    }
    
}
