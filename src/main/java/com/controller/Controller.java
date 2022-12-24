
package com.controller;

import com.model.Invoice;
import com.model.InvoiceLine;
import com.model.InvoiceTblModel;
import com.model.LinesTblModel;
import com.view.InvoiceLineView;
import com.view.InvoiceView;
import com.view.SIGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Controller implements ActionListener,ListSelectionListener{
    
    private SIGUI gui;
    private InvoiceView invoiceView;
    private InvoiceLineView invoiceLineView;
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
            case"createNewLine":
                createNewLine();
                break;
            case"deleteItems":
                deleteItems();
                break; 
            case"createInvoiceCancel":
                createInvoiceCancel();
                break; 
            case"createInvoiceOkay":
                createInvoiceOkay();
                break; 
            case"createNewLineCancel":
                createNewLineCancel();
                break; 
            case"createNewLineOkay":
                createNewLineOkay();
                break; 
                    
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = gui.getInvoiceTable().getSelectedRow();
        if (selectedInvIndex !=-1){
        System.out.println("Invoice selected : " + (selectedInvIndex+1) );
        Invoice currentInvoice = gui.getInvoices().get(selectedInvIndex);
        gui.getInvoiceDateLabel().setText(currentInvoice.getDate());
        gui.getInvoiceNumLabel().setText(""+currentInvoice.getinvoiceNo());
        gui.getInvoiceTotalLabel().setText(""+currentInvoice.getInvoiceTotal());
        gui.getCustomerNameLabel().setText(currentInvoice.getCustomerName());
        LinesTblModel linesTblModel = new LinesTblModel(currentInvoice.getLines());
        gui.getLineTable().setModel(linesTblModel);
        linesTblModel.fireTableDataChanged();
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
          ArrayList<Invoice> invoices = gui.getInvoices();
          String invoicesStrings = "";
          String linesStrings = "";
          for (Invoice invoice : invoices) {
            String invoiceCSV = invoice.getCSVFormat();
            invoicesStrings += invoiceCSV;
            invoicesStrings += "\n";
         for (InvoiceLine line : invoice.getLines()) {
                String lineCSV = line.getCSVFormat();
                linesStrings += lineCSV;
                linesStrings += "\n";
            }
        }
      
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(gui);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter headerFileWriter = new FileWriter(headerFile);
                headerFileWriter.write(invoicesStrings);
                headerFileWriter.flush();
                headerFileWriter.close();
                result = fc.showSaveDialog(gui);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(lineFile);
                    lineFileWriter.write(linesStrings);
                    lineFileWriter.flush();
                    lineFileWriter.close();
                     JOptionPane.showMessageDialog(gui,
                            "save succesful", "INFORMATION",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception ex) {
        }
    }

    private void createInvoice() {
        invoiceView = new InvoiceView(gui);
        invoiceView.setVisible(true);
        
    }


    private void deleteItems() {
        int selectedRow = gui.getLineTable().getSelectedRow();
        if(selectedRow != -1){
            LinesTblModel linesTblModel =  (LinesTblModel) gui.getLineTable().getModel();
            linesTblModel.getLines().remove(selectedRow);
            linesTblModel.fireTableDataChanged();
            System.out.println("herre");
        }
    }

    private void deleteInvoice() {
        int selectedRow = gui.getInvoiceTable().getSelectedRow();
        if (selectedRow != -1){
            gui.getInvoices().remove(selectedRow);
            gui.getInvoiceTblModel().fireTableDataChanged();
        }
    }

    private void createInvoiceCancel() {
        invoiceView.setVisible(false);
        invoiceView.dispose();
        invoiceView = null;
     }

    private void createInvoiceOkay() {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String invoiceDate = invoiceView.getInvoiceDateFeild().getText();
        String customerName = invoiceView.getCustomerNameFeild().getText();
      //  int No = gui.getNxtInvoiceNO();
        
        try{
            dateFormat.parse(invoiceDate);
             Invoice invoice = new Invoice(invoiceDate,customerName);
            gui.getInvoices().add(invoice);
            gui.getInvoiceTblModel().fireTableDataChanged();
            invoiceView.setVisible(false);
            invoiceView.dispose();
            invoiceView = null;
            
        } catch (ParseException ex){
            JOptionPane.showMessageDialog(gui, "Invalid","Error",JOptionPane.ERROR_MESSAGE);
                
                }
       
    }
 private void createNewLine() {
      invoiceLineView = new InvoiceLineView(gui);
      invoiceLineView.setVisible(true);
        
    }
 
    private void createNewLineCancel() {
        invoiceLineView.setVisible(false);
        invoiceLineView.dispose();
        invoiceLineView = null;
    }

    private void createNewLineOkay() {
        
        String itemName = invoiceLineView.getItemNameFeild().getText();
        String itemCount = invoiceLineView.getItemCountFeild().getText();
        String itemPrice = invoiceLineView.getItemPriceFeild().getText();
        int count = Integer.parseInt(itemCount);
        double price = Double.parseDouble(itemPrice);
        int selectedInvoice = gui.getInvoiceTable().getSelectedRow();
        System.out.println(selectedInvoice);
      
        if(selectedInvoice !=-1){
            Invoice invoice = gui.getInvoices().get(selectedInvoice);
            InvoiceLine invoiceLine = new InvoiceLine (selectedInvoice+1,itemName,price,count,invoice);
            invoice.getLines().add(invoiceLine);
            LinesTblModel linesTblModel = (LinesTblModel) gui.getLineTable().getModel();
            linesTblModel.fireTableDataChanged();
            gui.getInvoiceTblModel().fireTableDataChanged();
            
        }
            invoiceLineView.setVisible(false);
            invoiceLineView.dispose();
            invoiceLineView = null;
            
        System.out.println("okayissue");
     }

   

   
}
