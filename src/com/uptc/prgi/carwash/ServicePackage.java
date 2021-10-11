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
public enum ServicePackage {
    INTERIOR_WASH("Lavado Interior", 8000), 
    EXTERIOR_WASH("Lavado Exterior", 12000), 
    ENGINE_WASH("Lavado de Motor", 10000);
    
    private final String typeOfService;
    private final int priceOfService;
    
    
    private ServicePackage(String typeOfService, int priceOfService){
        this.typeOfService=typeOfService;
        this.priceOfService=priceOfService;
    }
    
    public String getTypeOfService(){
        return this.typeOfService;
    }
    
    public int getPriceOfService(){
        return this.priceOfService;
    }
}
