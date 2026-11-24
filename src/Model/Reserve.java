/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;
/**
 *
 * @author Bingo
 */
public class Reserve {
    int id;
    String roomnumber;
    Boolean isVip;
    LocalDate dateofreserve = LocalDate.now(); 

    public Reserve(int id, String roomnumber, Boolean isVip) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.isVip = isVip;
    }

    public int getId() {
        return id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public Boolean getIsVip() {
        return isVip;
    }

    public LocalDate getDateofreserve() {
        return dateofreserve;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setIsVip(Boolean isVip) {
        this.isVip = isVip;
    }

    public void setDateofreserve(LocalDate dateofreserve) {
        this.dateofreserve = dateofreserve;
    }
    
    public String dateToString()
    {
        return dateofreserve.toString();
    }
    
    @Override
    public String toString() {
        return (this.id+"\t"+this.roomnumber+"\t"+this.isVip+"\t"+dateToString());
    }
    
    public String toBoxString() {
        return ("ID: " + this.id+"\t RoomNumber: "+this.roomnumber+"\t isVip: "+this.isVip+"\t DateOfReserve: "+dateToString());
    }
    
    /*
    s[0] = s[0].replaceFirst("ID: ", "");
        s[1] = s[1].replaceFirst("RoomNumber: ", "");
        s[2] = s[2].replaceFirst("isVip: ", "");
        s[3] = s[3].replaceFirst("DateOfReserve: ", "");
    */
}

