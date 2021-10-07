/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.prgi.carwash;

/**
 *
 * @author luism
 */
public enum TypeVehicle {
    PUBLIC("Público"), PARTICULAR("Particular"), PRIVATE("Privado");
    
    private final String typeVehicle;
    
    
    private TypeVehicle(String typeVehicle){
        this.typeVehicle=typeVehicle;
    }
    
    public String getTypeVehicle(){
        return this.typeVehicle;
    }
}
