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
    
    private boolean determineAirFresher(){
        return true;
    }
    
    private int determineValueToPay(){
        return 0;
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
