/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;
import java.util.Date;

import static com.uptc.prgi.carwash.TypeVehicle.PUBLIC;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Luis Miguel Santiago 202023610
 * @date 6/10/2021  
 */
public class Sale{
    
    private Users user;
    private Date date;
    private int value;

    public Sale(Users user) {
        this.user = user;
        this.date = Date.from(getDateNow().toInstant());
        this.value = determineValueToPay();
    }
    
    public ZonedDateTime getDateNow(){
        LocalDate localDate = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);
        return zonedDateTime;  
    }

    public int getValue() {
        return value;
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
    public boolean determineAirFresher(){
        if(user.getVehicles().getTypeVehicle() == PUBLIC){
            return true;
        }
        return false;
    }
    
    /**
     * metodo que determina el valor total a pagar por los servicios con su descuento si fue el caso.
     * @return valor total
     */
    public int determineValueToPay(){
        int totalValue = 0;
        for(int i =0; i < user.getVehicles().getServicePackage().length; i++){
            totalValue += user.getVehicles().getServicePackage()[i].getPriceOfService();
        }
        if(determinePromotion()){
          totalValue -= totalValue*0.10f;   
        }
        return totalValue;
    }
    
    public Vehicles[] search(){
        return null;
    }
    
    public SalesReport[] salesReport(){
        return null;    
    }

}
