/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Cleaning;
import Control.FileAccess;
import java.util.ArrayList;


/**
 *
 * @author Bingo
 */
public class CleanerController {
    FileAccess fa = new FileAccess();
    
    public ArrayList<Cleaning> getAllRequests(){
        ArrayList<Cleaning> allrequests = fa.readCleaning();
        ArrayList<Cleaning> pendingrequests = new ArrayList();
        
        for(int i = 0; i<allrequests.size(); i++){
            if(allrequests.get(i).getIsCleaned() == false)
                pendingrequests.add(allrequests.get(i));
        }
        
        return pendingrequests;
    }
    
    public void setAsCleaned(String room){
        ArrayList<Cleaning> allrequests = fa.readCleaning();
        
        for(int i = 0; i<allrequests.size();i++)
        {
            if(allrequests.get(i).getRoomnumber().equals(room))
            {
                allrequests.get(i).setIsCleaned(true);
            }
        }
        
        fa.resetfile("Cleaning");
        for(int i =0; i <allrequests.size(); i++)
            fa.writeToFile("Cleaning", allrequests.get(i).toString());
    }
    
    public void removeCleaned(){
        ArrayList<Cleaning> allrequests = fa.readCleaning();
        ArrayList<Cleaning> newrequests = new ArrayList();
        
        for(int i = 0; i < allrequests.size(); i++)
        {
            if(allrequests.get(i).getIsCleaned() == false)
            {
                Cleaning c = new Cleaning(allrequests.get(i).getRoomnumber(), allrequests.get(i).getIsCleaned());
                newrequests.add(c);
            }
        }
        
        fa.resetfile("Cleaning");
        
        for(int i = 0; i<newrequests.size(); i++)
            fa.writeToFile("Cleaning", newrequests.get(i).toString() + "\n");
        
    }
    
}
