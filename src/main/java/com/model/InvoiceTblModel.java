
package com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceTblModel extends AbstractTableModel {
    private ArrayList<Invoice> invoices;
    private String [] coulmnsNO ={"NO.",};

    public InvoiceTblModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    
    @Override
    public int getRowCount() {
        return invoices.size();
        }

    @Override
    public int getColumnCount() {
        return 
       }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        }
    
}
