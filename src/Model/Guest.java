/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bingo
 */
public class Guest {
    String name;
    int age;
    int number;
    String nationality;

    public Guest(String name, int age, int number, String nationality) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return (this.name+"\t"+this.age+"\t"+this.number+"\t"+this.nationality);
    }
    
    public String toBoxString() {
        return ("Name: " + this.name+"\t Age: "+this.age+"\t CustomerNumber: "+this.number+"\t Nationality: "+this.nationality);
    }
    
    /*
    s[0] = s[0].replaceFirst(" Name: ", "");
        s[1] = s[1].replaceFirst(" Age: ", "");
        s[2] = s[2].replaceFirst(" CustomerNumber: ", "");
        s[3] = s[3].replaceFirst(" Nationality: ", "");
    */
}
