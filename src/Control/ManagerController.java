/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Bingo
 */
public class ManagerController {
    
    FileAccess fa = new FileAccess();
    
    public void addWorker(Worker worker){
        fa.writeToFile("Worker", worker.toString());
    }
    
    public void addRoom(Room room){
        fa.writeToFile("Room", room.toString());
    }
    
    
    public void removeRoom(Room room){
        ArrayList<Room> allrooms = fa.readRoom();
        ArrayList<Room> newrooms = new ArrayList();
        
        for(int i = 0; i<allrooms.size(); i++){
            if(!allrooms.get(i).getRoomnumber().equals(room.getRoomnumber()))
                newrooms.add(allrooms.get(i));
        }
        
        fa.resetfile("Room");
        
        for(int i = 0; i<newrooms.size();i++)
            fa.writeToFile("Room", newrooms.get(i).toString());
    }
    
    
    public void removeWorker(Worker worker){
        ArrayList<Worker> allworkers = fa.readWorker();
        ArrayList<Worker> newworkers = new ArrayList();
        
        for(int i = 0; i<allworkers.size(); i++){
            if(allworkers.get(i).getId() != worker.getId())
                newworkers.add(allworkers.get(i));
        }
        
        fa.resetfile("Worker");
        
        for(int i = 0; i<newworkers.size();i++)
            fa.writeToFile("Worker", newworkers.get(i).toString());
    }
    
    
    public void checkIncome(){
        int rows = fa.readIncome().size()/10;
        ArrayList<Archive> income = fa.readIncome();
        int[] order = {0,4,1,2,5,6,7,9,3,8};
        
        JTable table = new JTable(rows, 10);
        JFrame f = new JFrame();
        f.setSize(1500, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);
        /*
        table.getColumnModel().getColumn(0).setHeaderValue("ID");
        table.getColumnModel().getColumn(4).setHeaderValue("Name");
        table.getColumnModel().getColumn(1).setHeaderValue("Room number");
        
        table.getColumnModel().getColumn(2).setHeaderValue("Is Vip");
        table.getColumnModel().getColumn(5).setHeaderValue("Age");
        table.getColumnModel().getColumn(6).setHeaderValue("Number");
        table.getColumnModel().getColumn(7).setHeaderValue("Nationality");
       
        table.getColumnModel().getColumn(9).setHeaderValue("Has Checked out");
        table.getColumnModel().getColumn(3).setHeaderValue("Date of Reserve");
        table.getColumnModel().getColumn(8).setHeaderValue("Date of Checkout");
        */
        
        table.getColumnModel().getColumn(0).setHeaderValue("ID");
        table.getColumnModel().getColumn(1).setHeaderValue("Name");
        table.getColumnModel().getColumn(2).setHeaderValue("Room number");
        
        table.getColumnModel().getColumn(3).setHeaderValue("Is Vip");
        table.getColumnModel().getColumn(4).setHeaderValue("Age");
        table.getColumnModel().getColumn(5).setHeaderValue("Number");
        table.getColumnModel().getColumn(6).setHeaderValue("Nationality");
       
        table.getColumnModel().getColumn(7).setHeaderValue("Has Checked out");
        table.getColumnModel().getColumn(8).setHeaderValue("Date of Reserve");
        table.getColumnModel().getColumn(9).setHeaderValue("Date of Checkout");
        
        int currentval = 0;
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j<10; j++)
            {
                table.setValueAt(income.get(currentval),i,order[j]);
                currentval++;
            }
        }
        
        
    }
}
