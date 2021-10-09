/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;

/**
 *
 * @author Luis Miguel Santiago 202023610
 * @date 6/10/2021  
 */
public class Users {
    private String name;
    private String PhoneNumber;
    private Vehicles vehicles;
    private int sales;

    public Users(String name, String PhoneNumber, Vehicles vehicles) {
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }
      
}
