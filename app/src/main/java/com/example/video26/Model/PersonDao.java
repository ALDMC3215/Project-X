package com.example.video26.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("Select * From T_Person")
    List<Person> selectAll();

    //Update Method
    @Query("UPDATE T_Person SET Name = :newName, Family = :newFamily, PhoneNumber = :newPhoneNumber WHERE PersonId = :personId")
    void updateById(int personId, String newName, String newFamily, String newPhoneNumber);

    //Delete Method
    @Query("DELETE FROM T_Person WHERE PersonId = :personId")
    void deleteById(int personId);

    // Add this combined search method to your PersonDao
    @Query("SELECT * FROM T_Person WHERE Name LIKE '%' || :query || '%' OR Family LIKE '%' || :query || '%' OR PhoneNumber LIKE '%' || :query || '%'")
    List<Person> search(String query);

    //Insert Method
    @Insert
    void add(Person person);


}


