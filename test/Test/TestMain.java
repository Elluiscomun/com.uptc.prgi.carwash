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
import com.uptc.prgi.carwash.TypeVehicle;
import static com.uptc.prgi.carwash.TypeVehicle.PARTICULAR;
import static com.uptc.prgi.carwash.TypeVehicle.PUBLIC;
import com.uptc.prgi.carwash.Users;
import com.uptc.prgi.carwash.Vehicles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis Miguel Santiago 202023610
 * @date 9/10/2021  
 */
public class TestMain {
    
    private Scanner console;
    private SalesReport salesReport2;
    private Sale sale;
    
    public TestMain(){
        run();
    }
    
    public void run() {
        createTestData();
        int option = 0;
        do {
            String banner =    "____________________________________________________________________________\n" +
                               " __________________________________________________________________________\n" +
                               "|                                __________               [ManagerCarWash®]|\n" +
                               "|------------------------------ | CAR-WASH | ------------------------------|\n" +
                               "|__________________________________________________________________________|\n" +
                               "____________________________________________________________________________";
            System.out.println(banner);
            
            String mainMenu =  " __________________________________________________________________________\n" +
                               "|                             ________________                             |\n" +
                               "|--------------------------- | MENÚ PRINCIPAL | ---------------------------|\n" +
                               "|__________________________________________________________________________|\n" +
                               "|            ***** INGRESE EL NUMERO DE LA OPCION A ESCOGER: *****         |\n" +
                               " --------------------------------------------------------------------------\n" +
                               "|                [--->] 1. Registrar una nueva venta----->(1)              |\n" +
                               "|                [--->] 2. Consultar datos de venta------>(2)              |\n" +
                               "|                [--->] 3. Generar reporte de ventas----->(3)              |\n" +
                               "|                [--->] 4. Generar detallado de ventas--->(4)              |\n" +
                               "|                [--->] 5. Cerrar el programa------------>(5)              |\n" +
                               "|__________________________________________________________________________|";
            System.out.println(mainMenu);
            
            String formatOption = "____________________________________________________________________________";
            String format1 = " __________________________________________________________________________ ";
            String format2 = "|__________________________________________________________________________|";
            
            console = new Scanner(System.in);
            try{
                System.out.println(formatOption);
                option = Integer.parseInt(console.nextLine());
                System.out.println(formatOption);
            }catch(NumberFormatException x){
                
            }    
            switch(option) {
		case 1:
                    createNewSale();
                    break;
		case 2:
                    System.out.println(format1);
                    System.out.println("| Ingrese La Placa Del Vehiculo...                                         |");
                    System.out.println(formatOption);
                    show( salesReport2.searchByLicensePlate(console.nextLine().intern()));
                    break;
		case 3:
                    System.out.println("| 1.Generar Por Día...\n| 2.Generar Por Mes...\n| 3.Generar Por Año...");
                    try{
                        menuGenerateReport(Integer.parseInt(console.nextLine()),1);
                        System.out.println(formatOption);
                    }catch(NumberFormatException x){
                        break;
                    }    
                    break;
                case 4:
                    System.out.println("| 1.Generar Por Día...\n| 2.Generar Por Mes...\n| 3.Generar Por Año...");
                    try{
                        menuGenerateReport(Integer.parseInt(console.nextLine()),2);
                        System.out.println(formatOption);
                    }catch(NumberFormatException x){
                        break;
                    }    
                    break;
                case 5:
                    System.out.println("| El programa se ha cerrado exitosamente...");
                    System.out.println(formatOption);
                    break;
		default:
                    System.out.println("Seleccione una opcion correcta");
                    break;
            }
        }while(option != 5);
    
    } 
    
    
    public void createNewSale(){
        String formatOption = "____________________________________________________________________________";
        System.out.println(formatOption);
        System.out.println("| Ingrese el nombre del usuario:");
        System.out.println(formatOption);
        String name = console.nextLine();
        System.out.println(formatOption);
        System.out.println("| Ingrese el numero de contacto del usuario:");
        System.out.println(formatOption);
        String number = console.nextLine();
        System.out.println(formatOption);
        System.out.println("| Ingrese la placa del vehiculo:");
        System.out.println(formatOption);
        String licencePlaque = console.nextLine().intern();
        System.out.println(formatOption);
        System.out.println("| Digite el Tipo de Vehiculo ( PUBLIC || PARTICULAR )");
        System.out.println(formatOption);
        TypeVehicle tipeVehicle = null;
        try{
            tipeVehicle = TypeVehicle.valueOf(console.nextLine());
        }catch (IllegalArgumentException x){
            System.out.println(formatOption);
            System.out.println("| Digite un tipo de Vehiculo Valido !!!");
            System.out.println(formatOption);
            try{
                tipeVehicle = TypeVehicle.valueOf(console.nextLine());
                System.out.println(formatOption);
            }catch (IllegalArgumentException y){
                System.out.println(formatOption);
                System.out.println("| Ocurrió un error al intentar crear una venta nueva...");
                System.out.println(formatOption);
                run();
            }
        }
        
        System.out.println(formatOption);
        System.out.println("| Digite cuantos servicios va a adquirir el usuario: ");
        System.out.println(formatOption);
        ServicePackage[] servicePakage = createServicePackageArray(Integer.parseInt(console.nextLine()));

        Sale newSale = new Sale(new Users(name,number, new Vehicles(licencePlaque, tipeVehicle, servicePakage)));
        createNewSalesReport(newSale);
        System.out.println(formatOption);
        System.out.println("| El registro se ha realizado exitosamente...\n"
                + "| Valor Total a Pagar: $" + newSale.getValue() 
                + (newSale.determinePromotion()?"\n| Promocion/Descuento 10% Aplicada":"") 
                + (newSale.determineAirFresher()?"\n| ¡Se obsequia un ambientador! ":""));
    }
    
    
    public ServicePackage[] createServicePackageArray(int numberlength){
        String formatOption = "____________________________________________________________________________";
        ServicePackage[] servicePackage = new ServicePackage[numberlength];
        if(numberlength==3){
            servicePackage = ServicePackage.values();
        }else{
            for(int i = 0;i < servicePackage.length;i++){
                System.out.println(formatOption);
                System.out.println("| SERVICIO " + (i+1) + "\n| 1. Digite si el usuario va a adquirir: "+ ServicePackage.INTERIOR_WASH.getTypeOfService() 
                    + "\n| 2. Digite si el usuario va a adquirir: "+ServicePackage.EXTERIOR_WASH.getTypeOfService()
                    + "\n| 3. Digite si el usuario va a adquirir: "+ServicePackage.ENGINE_WASH.getTypeOfService());
                System.out.println(formatOption);
                servicePackage[i] = ServicePackage.values()[Integer.parseInt(console.nextLine())-1];
            }
        }
        return servicePackage;
    }
    
    
    public void show(SalesReport sales){
        String formatOption = "____________________________________________________________________________";
        System.out.println(formatOption);
        for(int i = 0; i < sales.getDatas().length; i++){
            System.out.println(sales.getDatas()[i]);
        }
        System.out.println(formatOption);
        System.out.println("| BÚSQUEDA FINALIZADA...");
    }
    
    
    public void menuGenerateReport(int option, int version){
        String formatOption = "____________________________________________________________________________";
        System.out.println(formatOption);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy");
        Date date = null;
        switch(option) {
		case 1:
                    System.out.println("| Digite la fecha a consultar con el formato : yyyy/MM/dd");
                    try{
                        System.out.println(formatOption);
                        date = format.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println(formatOption);
                        System.out.println("| LA FECHA INGRESADA ES ERRONEA...");
                        break;
                    }    
                    System.out.println(formatOption);
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByDate(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByDate(date))) );
                    break;
		case 2:
                    System.out.println("| Digite la fecha a consultar con el formato : yyyy/MM");
                    try{
                        System.out.println(formatOption);
                        date = format1.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println(formatOption);
                        System.out.println("| LA FECHA INGRESADA ES ERRONEA...");
                        break;
                    }
                    System.out.println(formatOption);
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByMount(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByMount(date))) );
                    break;
		case 3:
                    System.out.println("| Digite la fecha a consultar con el formato : yyyy");
                    try{
                        System.out.println(formatOption);
                        date = format2.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println(formatOption);
                        System.out.println("| LA FECHA INGRESADA ES ERRONEA...");
                        break;
                    }
                    System.out.println(formatOption);
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByYear(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByYear(date))) );
                    break;			
		default:
                    System.out.println(formatOption);
                    System.out.println("| Seleccione una opcion correcta");
                    break;
            }    
    }
    
 
    public void createNewSalesReport(Sale sale){
        int i = 0;
        Sale[] sales = new Sale[salesReport2.getDatas().length+1];
        while(i < sales.length-1){
            sales[i] = (Sale) salesReport2.getDatas()[i];
            i++;
        }
        sales[i] = sale;
        salesReport2 = new SalesReport(sales);
    }
    
    
    public void createTestData() {
        Sale sale1 = new Sale(new Users("NIKO BELLIC", 
                "3142859831", new Vehicles("UVD-200", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale2 = new Sale(new Users("ARMANDO LIOS", 
                "321598310099", new Vehicles("NPL-329", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale3 = new Sale(new Users("ALEX MORENO", 
                "3190031043", new Vehicles("KKD-100", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale4 = new Sale(new Users("MARIA GALLEJO", 
                "3118036108", new Vehicles("GAC-003", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale5 = new Sale(new Users("ANDRES GUTIERREZ", 
                "3134597958", new Vehicles("HIO-978", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH, ENGINE_WASH})));
        
        Sale sale6 = new Sale(new Users("DANNA TALERO", 
                "3203767200", new Vehicles("OUH-676", PUBLIC, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale7 = new Sale(new Users("JORGE NITALES", 
                "3501268922", new Vehicles("WEE-086", PARTICULAR, new ServicePackage[]{INTERIOR_WASH, EXTERIOR_WASH})));
        
        Sale sale8 = new Sale(new Users("EMERSON CASTRO", 
                "3518935478", new Vehicles("KYC-862", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale9 = new Sale(new Users("LUIS PEREZ", 
                "3109453217", new Vehicles("DLE-999", PUBLIC, new ServicePackage[]{INTERIOR_WASH})));
        
        Sale sale10 = new Sale(new Users("EDWIN VARGAS", 
                "3158963145", new Vehicles("MSX-409", PUBLIC, new ServicePackage[]{ENGINE_WASH})));
        
        salesReport2 = new SalesReport(new Sale[]{sale1,sale2,sale3,sale4,sale5,sale6,sale7,sale8,sale9,sale10});
    }
   
    
    public static void main(String[] args){
        new TestMain();
    }
}
