/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;

import java.util.Arrays;

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

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Placa=" + licensePlate + ", Tipo de Vehiculo=" + typeVehicle + "\nServicos : " + Arrays.toString(servicePackage) + "\n";
=======
        return "Placa=" + licensePlate + ", Tipo de Vehiculo=" + typeVehicle + ", Servicios : " + Arrays.toString(servicePackage) + '}';
>>>>>>> c8c1bc1ba908c708142542a0f01d17d830128c72
    }
    
    
}
