/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch;


import java.io.*;
/**
 *
 * @author User
 */
public class BiodataRecord implements Serializable {
    
    private String name;
    private String contact;
    private String date;
    private String gender;
    private String status;
    private String address;
    private String nation;
    private String email;

    public BiodataRecord(String name, String contact, String date, String gender, String status, String address, String nation, String email) {
        this.name = name;
        this.contact = contact;
        this.date = date;
        this.gender = gender;
        this.status = status;
        this.address = address;
        this.nation = nation;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
