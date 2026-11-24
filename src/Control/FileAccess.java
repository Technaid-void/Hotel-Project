/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import Model.*;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author Bingo
 */
public class FileAccess {
    
    public void writeToFile(String fileName, String str) {
        try {
            FileWriter stdinf = new FileWriter(fileName+".txt", true);
            stdinf.write(str + "\n");
            stdinf.close();
        } catch (IOException ioe) {} 
    }
    
    public void resetfile(String fileName) {
        try {
            FileWriter stdinf = new FileWriter(fileName+".txt", false);
            stdinf.write("");
            stdinf.close();
        } catch (IOException ioe) {} 
    }
    
    public ArrayList<Cleaning> readCleaning(){
        ArrayList<Cleaning> cleaning = new ArrayList();
        String line;
        String info[];
        
        try 
        {   
            FileInputStream fs = new FileInputStream("Cleaning.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >= 2)
                {
                    Cleaning c = new Cleaning(info[0], Boolean.valueOf(info[1]));
                    cleaning.add(c);
                }
                
            }
            in.close();
            
        }
        catch(IOException e) {}
        return cleaning;
        
    }
    
    public ArrayList<Guest> readGuest(){
        ArrayList<Guest> guest = new ArrayList();
        String line;
        String info[];
        
        try{
            FileInputStream fs = new FileInputStream("Guest.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >=4)
                {
                    Guest g = new Guest(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), info[3]);
                    guest.add(g);
                }
            }
            in.close();
        }
        catch(IOException e){}
        return guest;
    }
    
    public ArrayList<Reserve> readReserve(){
        ArrayList<Reserve> reserve = new ArrayList();
        String line;
        String info[];
        try{
            FileInputStream fs = new FileInputStream("Reserve.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >= 3)
                {
                    Reserve r = new Reserve(Integer.parseInt(info[0]), info[1], Boolean.valueOf(info[2]));
                    reserve.add(r);
                }
                
            }
            in.close();
        }catch(IOException e){}
        return reserve;
        
    }
    
    public ArrayList<Room> readRoom(){
        ArrayList<Room> room = new ArrayList();
        String line;
        String info[];
        try{
            FileInputStream fs = new FileInputStream("Room.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >=5)
                {
                    Room r = new Room(info[0], Integer.parseInt(info[1]), Boolean.valueOf(info[2]), Integer.parseInt(info[3]), Boolean.valueOf(info[4]));
                    room.add(r);
                }
                
            }
            in.close();
        }catch(IOException e){}
        return room;
    }
    
    public ArrayList<Worker> readWorker(){
        ArrayList<Worker> worker = new ArrayList();
        String line;
        String info[];
        
        try{
            FileInputStream fs = new FileInputStream("Worker.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >= 4)
                {
                    Worker w = new Worker(info[0], Integer.parseInt(info[1]), info[2], info[3]);
                    worker.add(w);
                }
                
            }
            in.close();
        }
        catch(IOException e) {}
        return worker;
    }
    
    public ArrayList<Archive> readIncome(){
        ArrayList<Archive> income = new ArrayList();
        ArrayList<Reserve> allreserve = readReserve();
        String line;
        String info[];
        try{
            FileInputStream fs = new FileInputStream("Income.txt");
            InputStreamReader ir=new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while(in.ready()){
                line = in.readLine();
                info=line.split("\t");
                
                if(info.length >= 10)
                {
                    Reserve r = new Reserve(Integer.parseInt(info[0]), info[1], Boolean.valueOf(info[2]));
                for(int i = 0; i<allreserve.size(); i++)
                    if(allreserve.get(i).getId() == r.getId())
                    {
                        r.setDateofreserve(allreserve.get(i).getDateofreserve());
                        break;
                    }
                Guest g = new Guest(info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6]), info[7]);
                LocalDate lDate = LocalDate.parse(info[8]);
                Archive i = new Archive(r, g, Boolean.valueOf(info[9]));
                i.setDateofcheckout(lDate);
                
                income.add(i);
                }
                
                
            }
            in.close();
        }catch(IOException e) {}
        return income;
    }
    
}
