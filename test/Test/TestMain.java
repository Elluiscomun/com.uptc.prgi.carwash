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
        run();//Siempre que se cree esta clase se ejecuta inicialmete el metodo run() que contiene nuestro menu
    }
    
    public void run() {
        createTestData(); //para efectos de prueba ejecutamos un metodo que nos entrega dostos quemados
        int option = 0;
        do {
<<<<<<< HEAD
            String menu = "1.Crear Venta Nueva\n2.Consultar Datos de venta\n3.Generar Reporte General de ventas\n4.Generar detallado de ventas\n5.SALIR";
            System.out.println(menu);
=======
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
                               "|                [--->] 4. Cerrar el programa------------>(4)              |\n" +
                               "|__________________________________________________________________________|";
            System.out.println(mainMenu);
            
            String formatOption = "____________________________________________________________________________";
            String format1 = " __________________________________________________________________________ ";
            String format2 = "|__________________________________________________________________________|";
            
>>>>>>> c8c1bc1ba908c708142542a0f01d17d830128c72
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
                    System.out.println("1.Generar por Día\n2.Generar por mes\n3.Generar por año");
                    try{
                        menuGenerateReport(Integer.parseInt(console.nextLine()),1);
                    }catch(NumberFormatException x){
                        break;
                    }    
                    break;
                case 4:
                    System.out.println("1.Generar por Día\n2.Generar por mes\n3.Generar por año");
                    try{
                        menuGenerateReport(Integer.parseInt(console.nextLine()),2);
                    }catch(NumberFormatException x){
                        break;
                    }    
                    break;
<<<<<<< HEAD
=======
                case 5:
                    System.out.println("El programa se ha cerrado exitosamente...");
                    break;
>>>>>>> c8c1bc1ba908c708142542a0f01d17d830128c72
		default:
                    System.out.println("Seleccione una opcion correcta");
                    break;
            }
        }while(option != 5);
    
    } 
    
    public void menuGenerateReport(int option, int version){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy");
        Date date = null;
        switch(option) {
		case 1:
                    System.out.println("Digite la fecha a consultar con el formato : yyyy/MM/dd");
                    try{
                        date = format.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println("Fecha erronea");
                        break;
                    }    
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByDate(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByDate(date))) );
                    break;
		case 2:
                    System.out.println("Digite la fecha a consultar con el formato : yyyy/MM");
                    try{
                        date = format1.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println("Fecha erronea");
                        break;
                    }
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByMount(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByMount(date))) );
                    break;
		case 3:
                    System.out.println("Digite la fecha a consultar con el formato : yyyy");
                    try{
                        date = format2.parse(console.nextLine().intern()); 
                    }catch(ParseException x){
                        System.out.println("Fecha erronea");
                        break;
                    }
                    System.out.println( (version==1?salesReport2.createSalesReport
                            (salesReport2.conditionByYear(date)):
                            salesReport2.createDetailSalesReport(salesReport2.conditionByYear(date))) );
                    break;			
		default:
                    System.out.println("Seleccione una opcion correcta");
                    break;
            }    
        
    
    }
    
    /**
     * Nos permite
     * @param sales 
     */
    public void show(SalesReport sales){
        if(sales.getDatas().length > 0){
            for(int i = 0; i < sales.getDatas().length; i++){
                System.out.println(sales.getDatas()[i]);
            }
            System.out.println("Fin de Busqueda");
        }else{
            System.out.println("No se encontraron resultados con el parametro propuesto");
        }    
    }
    
    public void createNewSale(){
        String formatOption = "____________________________________________________________________________";
        String format1 = " __________________________________________________________________________ ";
        String format2 = "|__________________________________________________________________________|";
        System.out.println(format1);
        System.out.println("Ingrese el nombre del usuario");
        String name = console.nextLine();
        System.out.println("Ingrese el numero del usuario");
        String number = console.nextLine();
        System.out.println("Ingrese la placa del vehiculo");
        String licencePlaque = console.nextLine().intern();
        System.out.println("Digite el Tipo de vehiculo ( PUBLIC o PARTICULAR)");
        TypeVehicle tipeVehicle = null;
        try{
            tipeVehicle = TypeVehicle.valueOf(console.nextLine());
        }catch (IllegalArgumentException x){
            System.out.println("Digite un tipo de Vehiculo Valido");
            try{
                tipeVehicle = TypeVehicle.valueOf(console.nextLine());
            }catch (IllegalArgumentException y){
                System.out.println("Error al Intenar Crear Venta Nueva");
                run();
            }
        }
        System.out.println("Digite cuantos servicios va a adquirir el usuario");
        ServicePackage[] servicePakage = createServicePackageArray(Integer.parseInt(console.nextLine()));

        Sale newSale = new Sale(new Users(name,number, new Vehicles(licencePlaque, tipeVehicle, servicePakage)));
        createNewSalesReport(newSale);
        System.out.println("La venta se creo exitosamente \nTotal venta : $"+ newSale.getValue() 
                + (newSale.determinePromotion()?"\nAhorro 10%":"") 
                + (newSale.determineAirFresher()?"\nLleva Gratis Ambientador":""));
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
        
        salesReport2 = new SalesReport(new Sale[]{sale1,sale2,sale3,sale4,sale5,sale6,sale7,sale8,sale9,sale10});
    }
    
    public ServicePackage[] createServicePackageArray(int numberlength){
        ServicePackage[] servicePackage = new ServicePackage[numberlength];
        if(numberlength==3){
            servicePackage = ServicePackage.values();
        }else{
            for(int i = 0;i < servicePackage.length;i++){
                System.out.println("SERVICIO " + (i+1) + "\nMarque 1 si el usuario va a adquirir "+ ServicePackage.ENGINE_WASH.getTypeOfService() 
                    + "\n Marque 2 Si el usuario va a adquirir "+ServicePackage.EXTERIOR_WASH.getTypeOfService() 
                    + "\n Marque 3 Si el usuario va a adquirir "+ServicePackage.INTERIOR_WASH.getTypeOfService());
                servicePackage[i] = ServicePackage.values()[Integer.parseInt(console.nextLine())-1];
            }
        }
        
        return servicePackage;
    }
    
    public static void main(String[] args){
        new TestMain();
    }
}
