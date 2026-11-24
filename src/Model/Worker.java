/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bingo
 */
public class Worker {
    String name;
    int id;
    String pass;
    String job; 
    //Manager
    //Receptionist
    //Cleaner

    public Worker(String name, int id, String pass, String job) {
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getJob() {
        return job;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return (this.name+"\t"+this.id+"\t"+this.pass+"\t"+this.job);
    }  
    
    public String toBoxString() {
        return ("Name: " + this.name+"\t ID: "+this.id+"\t Password: "+this.pass+"\t Job: "+this.job);
    }  
}

