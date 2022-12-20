
package com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceTblModel extends AbstractTableModel {
    private ArrayList<Invoice> invoices;
    private String [] columnsNO ={"NO.","Date","Customer","Total"};

    public InvoiceTblModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    
    @Override
    public int getRowCount() {
        return invoices.size();
        }

    @Override
    public int getColumnCount() {
        return columnsNO.length;
       }

    @Override
    public String getColumnName(int column) {
        return columnsNO [column];
    }
    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice invoice = invoices.get(rowIndex);
        
        switch (columnIndex){
            case 0:return invoice.getinvoiceNo();
            case 1:return invoice.getDate();
            case 2:return invoice.getCustomerName();
            case 3:return invoice.calculateInvoiceTotal();
            default:return"";
        }
        }
    
}
