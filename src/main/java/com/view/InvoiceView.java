
package com.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceView extends JDialog{
    private JTextField customerNameFeild;
    private JTextField invoiceDateFeild;
    private JLabel customerNameLbl;
    private JLabel invoiceDateLbl;
    private JButton okayBtn;
    private JButton cancelBtn;
    
    public InvoiceView (SIGUI gui){
        customerNameLbl = new JLabel("Customer Name");
        customerNameFeild = new JTextField(20);
        invoiceDateLbl = new JLabel("Date");
        invoiceDateFeild = new JTextField(20);
        okayBtn = new JButton("OK");
        cancelBtn = new JButton ("Cancel");
        
        okayBtn.setActionCommand("createInvoiceOkay");
        cancelBtn.setActionCommand("createInvoiceCancel");
               
        okayBtn.addActionListener(gui.getCntrler());
        cancelBtn.addActionListener(gui.getCntrler());
        setLayout(new GridLayout(3,2));
        
        add(customerNameLbl);
        add(customerNameFeild);
        add(invoiceDateLbl);
        add(invoiceDateFeild);
        add(okayBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getCustomerNameFeild() {
        return customerNameFeild;
    }

    public JTextField getInvoiceDateFeild() {
        return invoiceDateFeild;
    }
   
    
}
