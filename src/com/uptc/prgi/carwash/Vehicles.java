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
public class Vehicles {
    
    private String licensePlate;
    private TypeVehicle typeVehicle;
    private ServicePackage[] servicePackage;

    public Vehicles(String licensePlate, TypeVehicle typeVehicle, ServicePackage[] servicePackage) {
        this.licensePlate = licensePlate;
        this.typeVehicle = typeVehicle;
        this.servicePackage = servicePackage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public ServicePackage[] getServicePackage() {
        return servicePackage;
    }
    
}
