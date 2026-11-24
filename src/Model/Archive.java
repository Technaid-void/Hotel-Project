/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author jaafar
 */
public class Archive {
    int id; //reserve id from guest
    String roomnumber; //reserve roomnumber
    Boolean isVip; //reserve vip
    LocalDate dateofreserve; 
    
    String name; //guest name
    int age; //guest age
    int number; //guest number
    String nationality; //guest nationality
    
    LocalDate dateofcheckout = LocalDate.MIN;
    Boolean hascheckedout;
    
    
    public Archive(Reserve reserve, Guest guest, Boolean hascheckedout){
        id = reserve.getId();
        name = guest.getName();
        isVip = reserve.getIsVip();
        number = guest.getNumber();
        roomnumber = reserve.getRoomnumber();
        dateofreserve = reserve.getDateofreserve();
        age = guest.getAge();
        nationality = guest.getNationality();
        this.hascheckedout = hascheckedout;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public int getNumber() {
        return number;
    }
    
    public Boolean getIsVip() {
        return isVip;
    }

    public LocalDate getDateofreserve() {
        return dateofreserve;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getDateofcheckout() {
        return dateofcheckout;
    }

    public Boolean getHascheckedout() {
        return hascheckedout;
    }

    public void setHascheckedout(Boolean hascheckedout) {
        this.hascheckedout = hascheckedout;
    }

    public void setDateofcheckout(LocalDate dateofcheckout) {
        this.dateofcheckout = dateofcheckout;
    }
    
    @Override
    public String toString() {
        return (this.id + "\t" + this.roomnumber + "\t" + this.isVip + "\t" + this.dateofreserve + "\t" + //reserve
                this.name + "\t" + this.age + "\t" + this.number +"\t" +this.nationality + "\t" +  //guest
                this.dateofcheckout + "\t" + this.hascheckedout); //other
    }
    
    public String toBoxString() {
        return ("ID: " + this.id + "\t RoomNumber: " + this.roomnumber + "\t isVip: " + this.isVip + "\t DateOfReserve: " + this.dateofreserve + "\t Name: " + //reserve
                this.name + "\t Age: " + this.age + "\t CustomerNumber: " + this.number +"\t Nationality: " +this.nationality + "\t DateOfCheckout: " +  //guest
                this.dateofcheckout + "\t HasCheckedout: " + this.hascheckedout); //other
    }
}
