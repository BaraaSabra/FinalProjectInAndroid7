package com.example.finalprojectinandroid.RoomDataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.sql.Date;

@TypeConverters({DateConverter.class})
@Entity
public class Users {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;
    String BirtheDate;
    String gender;
    String country;


    public Users(String name, String email, String BirtheDate, String gender, String country) {
        this.name = name;
        this.email = email;
        this.BirtheDate = BirtheDate;
        this.gender = gender;
        this.country = country;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return BirtheDate;
    }

    public void setDate(String date) {
        this.BirtheDate = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Users(int id, String name, String email, String date, String gender, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.BirtheDate = date;
        this.gender = gender;
        this.country = country;
    }


}
