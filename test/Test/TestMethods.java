/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;


import com.uptc.prgi.carwash.Sale;
import com.uptc.prgi.carwash.ServicePackage;
import static com.uptc.prgi.carwash.ServicePackage.ENGINE_WASH;
import static com.uptc.prgi.carwash.ServicePackage.EXTERIOR_WASH;
import static com.uptc.prgi.carwash.ServicePackage.INTERIOR_WASH;
import static com.uptc.prgi.carwash.TypeVehicle.PUBLIC;
import com.uptc.prgi.carwash.Users;
import com.uptc.prgi.carwash.Vehicles;

/**
 *
 * @author Edwin Niño
 */
public class TestMethods {
    public static void main(String[] args){
        
        Sale sale = new Sale(new Users("Niko Bellic", 
                "3203717234", new Vehicles("BHD-123", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        boolean t = management.determinePromotion();
        
        System.out.println("CASO #1:" + (management.determinePromotion()? "OK":"FALSE"));
        
        Management management1 = new Management(new Users("Niko Bellic", 
                "3203717234", new Vehicles("BHD-123", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        int totalValue = management1.determineValueToPay();
        
        System.out.println("CASO #1B:" + (management1.determineValueToPay() == 20000? "OK":"FALSE"));
    }
}
