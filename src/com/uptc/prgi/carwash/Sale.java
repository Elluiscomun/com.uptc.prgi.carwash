 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;
import static com.uptc.prgi.carwash.TypeVehicle.PUBLIC;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    public Users getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
    
    
    /**
     * Determinar si el usuario aplica a la promocion/descuento del valor total a pagar si adquiere 
     * los tres servicios que ofrece el lavadero de autos "Car Wash"...
     * @return boolean
     */
    public boolean determinePromotion(){
        return user.getVehicles().getServicePackage().length==3;
    }
    
    
    /**
     * Determinar que si el vehiculo es de tipo PÚBLICO, por lo que si lo anterior resulta 
     * ser verdadero el usuario aplica para recibir un ambientador de obsequio...
     * @return 
     */
    public boolean determineAirFresher(){
        return user.getVehicles().getTypeVehicle() == PUBLIC;
    }
    
    
    /**
     * Determinar el valor total a pagar por los servicios que ha utilizado del lavadero de autos,
     * ademas de realizar el respectivo descuento si el usuario aplica a él...
     * @return int valor total a pagar...
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
      
    
    @Override
    public String toString() {
        return "VENTA[" + "Usuario: " + user + "\n, Fecha=" + date + ", Valor=" + value + '}';
    }
    
}
