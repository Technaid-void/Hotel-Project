/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.*;
import View.Voucher;
import Control.FileAccess;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTable;
/**
 *
 * @author Bingo
 */
        
public class ReceptionistController {
    
    public static String username = "Guest";
    public static String nationality = "Libanese";
    public static String room = "000";
    public static String roomsize = "1";
    public static String roomprice = "9999";
    public static String vip = "no";
    
    FileAccess fa = new FileAccess();
    Voucher vc = new Voucher();

    
    public void callForCleaner(Room location){
        Cleaning c = new Cleaning(location.getRoomnumber(), false);
        fa.writeToFile("Cleaning", c.toString());
    }
    
    public void addGuest(Guest guest){
        fa.writeToFile("Guest", guest.toString());
    }
    
    
    public void checkIn(Guest guest, Room room){ //to add a guest
        Reserve reserve = new Reserve(guest.getNumber(), room.getRoomnumber(), room.getIsVip());
        Archive income = new Archive(reserve, guest,false);
        
        fa.writeToFile("Reserve", reserve.toString());
        fa.writeToFile("Income", income.toString());
    }
    
    public void checkOut(Reserve reserve){
        ArrayList<Reserve> allreserves = fa.readReserve();
        ArrayList<Reserve> newreserves = new ArrayList();
        
        ArrayList<Archive> allincome = fa.readIncome();
        
        for(int i = 0; i < allreserves.size(); i++)
        {
            if(!(allreserves.get(i).getId() == reserve.getId() && allreserves.get(i).getRoomnumber().equals(reserve.getRoomnumber())))
                newreserves.add(allreserves.get(i));
        }
        
        for(int i = 0; i<newreserves.size(); i++)
        {
            for(int j = 0; j<allincome.size(); j++)
            {
                if(allincome.get(j).getId() == newreserves.get(i).getId())
                {
                    allincome.get(i).setHascheckedout(true);
                    allincome.get(i).setDateofcheckout(LocalDate.now());
                }
            }
        }
        
        printvoucher(reserve);
        
        fa.resetfile("Reserve");
        for(int i = 0; i<newreserves.size(); i++)
            fa.writeToFile("Reserve", newreserves.get(i).toString());
        
        fa.resetfile("Income");
        for(int i = 0; i<allincome.size(); i++)
            fa.writeToFile("Income", allincome.get(i).toString());
        
    }
    
    public void printvoucher(Reserve reserve){
        ArrayList <Guest> g = fa.readGuest();
        ArrayList<Room> r = fa.readRoom();
        for(int i = 0; i < g.size(); i++)
        {
            if(g.get(i).getNumber() == reserve.getId())
            {
                this.username = g.get(i).getName();
                this.nationality = g.get(i).getNationality();
            }
        }
        
        for(int j = 0; j<r.size();j++)
        {
            if(r.get(j).getRoomnumber().equals(reserve.getRoomnumber()))
            {
                this.room = r.get(j).getRoomnumber();
                this.roomsize = Integer.toString(r.get(j).getSize());
                this.roomprice = Double.toString(r.get(j).getPrice());
            }
        }
        this.vip = Boolean.toString(reserve.getIsVip());
        
    }
    
    public ArrayList<Cleaning> getAllCleaned(){
        ArrayList<Cleaning> allrequests = fa.readCleaning();
        return allrequests;
    }

}
