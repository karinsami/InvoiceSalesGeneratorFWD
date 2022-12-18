
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        switch (actionCommand){
            case"load file":
                loadFile();
                break;
            case"save file":
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

    private void loadFile() {
        

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
