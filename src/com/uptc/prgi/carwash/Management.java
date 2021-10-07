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
public class Management {
    
    private Users user;

    public Management(Users user) {
        this.user = user;
    }
    
    public boolean determinePromotion(){
        if(user.getVehicles().getServicePackage().length==3){
            return true;
        }
        return false;
    }
    
        /**
     * Tetermina si vehiculo es publico por lo tanto recibe ambientador de regalo
     * @return 
     */
    private boolean determineAirFresher(){
        if(user.getVehicles().getTypeVehicle() == PUBLIC){
            return true;
        }
        return false;
    }
    
    /**
     * metodo que determina el valor total a pagar por los servicios con su descuento si fue el caso.
     * @return valor total
     */
    private int determineValueToPay(){
        int totalValue = 0;
        for(int i =0; i < user.getVehicles().getServicePackage().length; i++){
            totalValue += user.getVehicles().getServicePackage()[i].getPriceOfService();
        }
        if(determinePromotion()){
          totalValue -= totalValue*0.10f;   
        }
        return totalValue;
    }
    
    private void sort(){
    
    }
    
    private Vehicles[] search(){
        return null;
    }
    
    private SalesReport[] salesReport(){
        return null;    
    }

}
