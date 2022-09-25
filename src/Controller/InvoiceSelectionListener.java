/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.ActionsListener.simpleDateFormat;
import Models.Header;
import Models.Items;
import Models.ItemsTable;
import View.AppMainFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Adam
 */
public class InvoiceSelectionListener implements ListSelectionListener{

    private AppMainFrame appFrame;

    public InvoiceSelectionListener(AppMainFrame appFrame) {
        this.appFrame = appFrame;
    }

    public InvoiceSelectionListener() {
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInoviceIndex = appFrame.getInvoicesTable().getSelectedRow();
        if (selectedInoviceIndex != -1){
            Header selectedInvoice = appFrame.getHeaderArrayList().get(selectedInoviceIndex);
            ArrayList<Items> itemArrayList = selectedInvoice.getLines();
            ItemsTable itemsTable = new ItemsTable(itemArrayList);
            appFrame.setItemsArrayList(itemArrayList);
            appFrame.getInvoiceItemsTable().setModel(itemsTable);
            appFrame.getInvoiceNumerValueLabel().setText("" + selectedInvoice.getInvoiceNumber());
            appFrame.getCustomerNameValueLabel().setText(selectedInvoice.getCutomer());
            appFrame.getInvoiceDateValueLabel().setText(simpleDateFormat.format(selectedInvoice.getInvoiceDate()));
            appFrame.getInvoiceTotalValueLabel().setText("" + selectedInvoice.getTotal());
        }      
    }
    
}
