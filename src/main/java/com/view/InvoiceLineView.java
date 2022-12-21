
package com.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


// @author KARIN
 
public class InvoiceLineView extends JDialog{
    
    private JTextField itemNameFeild;
    private JTextField itemCountFeild;
    private JTextField itemPriceFeild;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton okayBtn;
    private JButton cancelBtn;
    
    public InvoiceLineView (SIGUI gui){
        itemNameLbl = new JLabel("item Name");
        itemNameFeild = new JTextField(20);
        itemCountLbl = new JLabel("Count");
        itemCountFeild = new JTextField(20);
         itemPriceLbl = new JLabel("item Price");
        itemPriceFeild = new JTextField(20);
        okayBtn = new JButton("OK");
        cancelBtn = new JButton ("Cancel");
        
        okayBtn.setActionCommand("createNewLineOkay");
        cancelBtn.setActionCommand("createNewLineCancel");
               
        okayBtn.addActionListener(gui.getCntrler());
        cancelBtn.addActionListener(gui.getCntrler());
        setLayout(new GridLayout(4,2));
        
        add(itemNameFeild);
        add(itemCountFeild);
        add(itemNameLbl);
        add(itemCountLbl);
        add(okayBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getItemNameFeild() {
        return itemNameFeild;
    }

    public JTextField getItemCountFeild() {
        return itemCountFeild;
    }

    public JTextField getItemPriceFeild() {
        return itemPriceFeild;
    }

    
   
    
}

    

