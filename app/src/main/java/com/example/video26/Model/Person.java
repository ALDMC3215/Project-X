package com.example.video26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_Person")

public class Person {

    @ColumnInfo(name = "PersonId")
    @PrimaryKey(autoGenerate = true)
    private int personId;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Family")
    public String family;

    @ColumnInfo(name = "Username")
    public String username;

    @ColumnInfo(name = "PhoneNumber")
    public String phoneNumber;

    @ColumnInfo(name = "Password")
    public String password;


    public Person(String name, String family, String username, String phoneNumber, String password) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
