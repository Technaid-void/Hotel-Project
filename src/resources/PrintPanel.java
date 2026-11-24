/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.awt.*;
import java.awt.print.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import View.Voucher;
/**
 *
 * @author jaafar
 */
public class PrintPanel {
    
    public void printpanel(JPanel panel){
        PrinterJob printerjob = PrinterJob.getPrinterJob();
        
        Voucher vn = new Voucher();
        printerjob.setJobName("Voucher");
        printerjob.setPrintable(new Printable(){
            @Override
            public int print(Graphics graphics, PageFormat pageformat, int pageindex) throws PrinterException{
                if(pageindex > 0 )
                    return Printable.NO_SUCH_PAGE;
                
                Graphics2D graphics2d = (Graphics2D)graphics;
                
                graphics2d.translate(pageformat.getImageableX()*2, pageformat.getImageableY()*2);
                graphics2d.scale(0.5, 0.5);
                
                panel.paint(graphics2d);
                
                return Printable.PAGE_EXISTS;
            }
        });
        
        boolean returningresult = printerjob.printDialog();
        
        if(returningresult){
            try{
                printerjob.print();
            }catch(PrinterException e){
                JOptionPane.showMessageDialog(vn,"Print error" + e.getMessage());
            }
        }
    }
}
