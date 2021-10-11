/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.uptc.prgi.carwash.Sale;
import com.uptc.prgi.carwash.SalesReport;
import com.uptc.prgi.carwash.ServicePackage;
import static com.uptc.prgi.carwash.ServicePackage.ENGINE_WASH;
import static com.uptc.prgi.carwash.ServicePackage.EXTERIOR_WASH;
import static com.uptc.prgi.carwash.ServicePackage.INTERIOR_WASH;
import static com.uptc.prgi.carwash.TypeVehicle.PARTICULAR;
import static com.uptc.prgi.carwash.TypeVehicle.PUBLIC;
import com.uptc.prgi.carwash.Users;
import com.uptc.prgi.carwash.Vehicles;

/**
 *
 * @author Edwin Niño
 */
public class TestAirFresherReport {

    public void testsAirFresherReport(){
        
        Sale sale1 = new Sale(new Users("Niko Bellic", 
                "3142859831", new Vehicles("UVD-200", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale2 = new Sale(new Users("Armando Lios", 
                "321598310099", new Vehicles("NPL-329", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale3 = new Sale(new Users("Alex Moreno", 
                "3190031043", new Vehicles("KKD-100", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale4 = new Sale(new Users("Maria Gallejo", 
                "3118036108", new Vehicles("GAC-003", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale5 = new Sale(new Users("Andres Gutierrez", 
                "3134597958", new Vehicles("HIO-978", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale6 = new Sale(new Users("Danna Herandez", 
                "3203767200", new Vehicles("OUH-676", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale7 = new Sale(new Users("Miguel Castellanos", 
                "3501268922", new Vehicles("WEE-086", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale8 = new Sale(new Users("Emerson Castro", 
                "3518935478", new Vehicles("KYC-862", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale9 = new Sale(new Users("Luis Perez", 
                "3109453217", new Vehicles("DLE-999", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale10 = new Sale(new Users("Edwin Vargas", 
                "3158963145", new Vehicles("MSX-409", PUBLIC, new ServicePackage[]{ENGINE_WASH})));
        
        
        SalesReport salesReport1 = new SalesReport(new Sale[]{sale1,sale2,sale3,sale4,sale5});
        SalesReport salesReport2 = new SalesReport(new Sale[]{sale6,sale7,sale8,sale9,sale10});
        SalesReport salesReport3 = new SalesReport(new Sale[]{sale1,sale2,sale3,sale4,sale5,sale6,sale7,sale8,sale9,sale10});
        
        
        System.out.println("CASOS DE PRUEBA: CANTIDAD DE AMBIENTADORES QUE SE HAN OBSEQUIADO...");
        System.out.println("PARA UN PRIMER REPORTE:");
        System.out.println("CASO #1A:" + (salesReport1.countAirFresher()==3?" OK ":" ERROR "));
        
        System.out.println();
        
        System.out.println("PARA UN SEGUNDO REPORTE:");
        System.out.println("CASO #2A:" + (salesReport2.countAirFresher()==4?" OK ":" ERROR "));
        
        System.out.println();
        
        System.out.println("PARA UN TERCER REPORTE:");
        System.out.println("CASO #3A:" + (salesReport3.countAirFresher()==7?" OK ":" ERROR "));
         
    }
        
        
    public static void main(String[] args) {
        
        TestAirFresherReport testAirFresherReport = new TestAirFresherReport();
        testAirFresherReport.testsAirFresherReport();
    }
    
}
