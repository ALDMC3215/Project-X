package com.example.video26;

import androidx.annotation.NonNull;

public class Person {

    private int Id;
    private String Name;
    private String Family;

    public Person(int id, String name, String family) {
        Id = id;
        Name = name;
        Family = family;
    }


    public Person() {
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    @NonNull
    public String toString() {
        return Id + "\t" + Name + "\t" + Family;
    }
}
