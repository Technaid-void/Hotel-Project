/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bingo
 */
public class Room {
    String roomnumber;
    int size;
    Boolean isVip;
    Boolean isReserved=false;
    int price;

    public Room(String roomnumber, int size, Boolean isVip,int price, Boolean isReserved) {
        this.roomnumber = roomnumber;
        this.size = size;
        this.isVip = isVip;
        this.price=price;
        this.isReserved = isReserved;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setIsVip(Boolean isVip) {
        this.isVip = isVip;
    }

    public void setReserved(Boolean isReserved) {
        this.isReserved = true;
    }
     public void setunReserved(Boolean isReserved) {
        this.isReserved = false;
    } 

    public String getRoomnumber() {
        return roomnumber;
    }

    public int getSize() {
        return size;
    }

    public Boolean getIsVip() {
        return isVip;
    }

    public Boolean getIsReserved() {
        return isReserved;
    }
  @Override
    public String toString() {
        return (this.roomnumber+"\t"+this.size+"\t"+this.isVip+"\t"+this.price+"\t"+this.isReserved);
    }  
    
    public String toBoxString(){
        return ("RoomNumber: " + this.roomnumber+ "\t Size: "+this.size+"\t isVip: "+this.isVip+"\t Price: "+this.price+"\t isReserved: "+this.isReserved);
    }
    
    /*
    s[0] = s[0].replaceFirst("RoomNumber: ", "");
        s[1] = s[1].replaceFirst("Size: ", "");
        s[2] = s[2].replaceFirst("isVip: ", "");
        s[3] = s[3].replaceFirst("Price: ", "");
        s[4] = s[4].replaceFirst("isReserved: ", "");
    */
}
