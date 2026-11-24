/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import Model.Guest;
import Model.Room;
import java.util.Random;
/**
 *
 * @author jaafar
 */
public class RandomIdGenerator {
    Random rand = new Random();
    public int generateID(String name,int age){
        String sgenerated = "";
        int ngenerated = 0;
        try{
            char[] a = name.toCharArray();
            for(int i=0;i<8; i++)
            {
                int ref = rand.nextInt((a.length - 1) + 1) + 1;
                int newnum = (int) a[ref];
                
                if(newnum > 10)
                    sgenerated += newnum%10;
                else
                    sgenerated += newnum;
            }
            sgenerated += age;
            
            
        }
        catch(Exception e) {}
        ngenerated = Integer.parseInt(sgenerated);
        return ngenerated;
    }
    
    public int generateWorkID(String name){
        String sgenerated = "";
        int ngenerated = 0;
        try{
            
            char[] a = name.toCharArray();
            for(int i=0;i<8; i++)
            {
                int ref = rand.nextInt((a.length - 1) + 1) + 1;
                int newnum = (int) a[ref];
                
                if(newnum > 10)
                    sgenerated += newnum%10;
                else
                    sgenerated += newnum;
            }
            
        }
        catch(Exception e) {}
        /*finally
        {
            generated += rand.nextInt((10 - 1) + 1) + 1;
            generated *= rand.nextInt((10 - 1) + 1) + 1;
        }*/
        ngenerated = Integer.parseInt(sgenerated);
        return ngenerated;
    }
}
