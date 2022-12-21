
package com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class LinesTblModel extends AbstractTableModel {
    private ArrayList<InvoiceLine> lines;
    private String [] columnsNO ={"NO.","Item Name","Item Price","Count","Item Total"};

    public LinesTblModel(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }
    

    @Override
    public int getRowCount() {
         return lines.size();
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
        InvoiceLine invoiceLine = lines.get(rowIndex);
        
        switch (columnIndex){
            case 0:return invoiceLine.getLineNo();
            case 1:return invoiceLine.getitemName();
            case 2:return invoiceLine.getitemPrice();
            case 3:return invoiceLine.getitemCount();
            case 4:return invoiceLine.calculateItemTotal();
            
            default:return"";
     }
        }
    
}
