
package com.controller;

import com.model.Invoice;
import com.model.InvoiceLine;
import com.model.InvoiceTblModel;
import com.view.SIGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class Controller implements ActionListener{
    
    private SIGUI gui;

    public Controller(SIGUI gui){
        this.gui = gui;
        

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        switch (actionCommand){
            case"Load File":
                loadFile();
                break;
            case"Save File":
                saveFile();
                break; 
            case"Create New Invoice":
                createInvoice();
                break; 
            case"Delete Invoice":
                deleteInvoice();
                break;
            case"Save":
                saveLine();
                break;
            case"Cancel":
                cancel();
                break;   
                
        }
    }

    private void loadFile()  {
        JFileChooser fileChooser = new JFileChooser();
        try {                    
        int respone = fileChooser.showOpenDialog(gui);
         ArrayList<Invoice> invoiceDataArray;    
                invoiceDataArray = new ArrayList<>();
        if (respone == JFileChooser.APPROVE_OPTION){
            File invoiceFile = fileChooser.getSelectedFile();
            Path invoicePath = Paths.get(invoiceFile.getAbsolutePath());
            List<String> invoiceData = Files.readAllLines(invoicePath);   
            System.out.println("file was loaded");
            
       
        for (String headerData :invoiceData) {
           String[] invoiceDetails = headerData.split(",");
           int NO = Integer.parseInt(invoiceDetails[0]);
           String date = invoiceDetails[1];
           String customer = invoiceDetails[2];
           Invoice invoice = new Invoice(NO,date,customer);
           invoiceDataArray.add(invoice);
        }  
        }
        respone = fileChooser.showOpenDialog(gui);
        if (respone == JFileChooser.APPROVE_OPTION){
            File lineFile = fileChooser.getSelectedFile();
            Path linePath = Paths.get(lineFile.getAbsolutePath());
            List<String> lineData = Files.readAllLines(linePath);   
            System.out.println("file was loaded");
            
        ArrayList<InvoiceLine> lineDataArray;    
                lineDataArray = new ArrayList<>();
        for (String fileData :lineData) {
           String[] lineDetails = fileData.split(",");
           int NO = Integer.parseInt(lineDetails[0]);
           String itemsName = lineDetails[1];
           double itemsPrice = Double.parseDouble(lineDetails[2]);
           int itemCount = Integer.parseInt(lineDetails[3]);
           
        for(Invoice invoice : invoiceDataArray)   
              if (invoice.getinvoiceNo() == NO){
                 
                InvoiceLine line = new InvoiceLine(NO,itemsName,itemsPrice,itemCount,invoice );
                invoice.getLines().add(line);
                  
        break;
                  
              }
         
        }    
        gui.setInvoices(invoiceDataArray);
        InvoiceTblModel invoiceTblModel = new InvoiceTblModel (invoiceDataArray);
        gui.setInvoiceTblModel(invoiceTblModel);
        gui.getInvoiceTable().setModel(invoiceTblModel);
        gui.getInvoiceTblModel().fireTableDataChanged();
                
        
        }  
           
    }  catch (IOException ex){
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
   


    }
        

    private void saveFile() {
    }

    private void createInvoice() {
    }

    private void saveLine() {
    }

    private void cancel() {
    }

    private void deleteInvoice() {
    }
    
}
