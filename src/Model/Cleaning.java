/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bingo
 */
public class Cleaning {
    String roomnumber;
    Boolean isCleaned;

    public Cleaning(String roomnumber, Boolean isCleaned) {
        this.roomnumber = roomnumber;
        this.isCleaned = isCleaned;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public Boolean getIsCleaned() {
        return isCleaned;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setIsCleaned(Boolean isCleaned) {
        this.isCleaned = isCleaned;
    }

    @Override
    public String toString() {
        return (this.roomnumber+"\t"+this.isCleaned);
    }
    
    public String toBoxString() {
        return ("RoomNumber: " + this.roomnumber+"\t isCleaned: "+this.isCleaned);
    }
}
