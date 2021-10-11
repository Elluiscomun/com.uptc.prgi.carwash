/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Luis Miguel Santiago 202023610
 * @date 6/10/2021  
 */
public class SalesReport<T> {

    private T[] datas;
   
    public SalesReport(T[] datas){
        this.datas = datas;
    }
    
    public T[] getDatas() {
        return datas;
    }
    
    private void swap(int i, int j){
        T aux = this.datas[j];
        this.datas[j]=this.datas[i];    
        this.datas[i]=aux;
    }
    
    
    public SalesReport<T> bubbleSort(Comparator<T> comparator) {
        SalesReport<T> result = new SalesReport(datas);
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < datas.length - 1; i++) {
                if (comparator.compare(this.datas[i], result.datas[i + 1]) > 0) {
                    result.swap(i, i + 1);
                    change = true;
                }
            }
        }
        return result;
    }
    
    
    public void sortByValue(){
        bubbleSort(comparatorByValue());
    }
    
    
    public Comparator comparatorByValue(){
        Comparator<Sale> comparator = new Comparator<Sale>() {
            @Override
            public int compare(Sale t1, Sale t2) {
                return t1.getValue() - t2.getValue();
            }
        };
        return comparator;
    }
    
    
    public int count(ISalesReport<T> iSalesReport){
        int count = 0;
        for (int i = 0; i < datas.length; i++) {
            if(iSalesReport.isInto(datas[i])){
                count++;
            }
        }
        return count;
    }
    
    
    public int countValue(IValue<T> iValue){
        int count = 0;
        for (int i = 0; i < datas.length; i++) {
            count += iValue.isInto(datas[i]);
        }
        return count;
    }
    
    
    public SalesReport<T> search(ISalesReport<T> iSalesReport){
        T[] result = (T[]) new Object[count(iSalesReport)];
        int founds = 0;
        for (int i = 0; i < datas.length; i++) {
            if(iSalesReport.isInto(datas[i])){
                result[founds] = datas[i];
                founds++;
            }
        }
        return new SalesReport<>(result);
    }
   
    
    public ISalesReport<Sale> conditionByLicensePlate(String value){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return value == info.getUser().getVehicles().getLicensePlate();
            }
        
        };
    }
    
    
    public ISalesReport<Sale> conditionByDate(Date value){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return value.getDay() == info.getDate().getDay() &&
                        value.getMonth() == info.getDate().getMonth() &&
                        value.getYear() == info.getDate().getYear();
            }
        
        };
    }
    
    
    public ISalesReport<Sale> conditionByMount(Date value){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return value.getMonth() == info.getDate().getMonth() &&
                        value.getYear() == info.getDate().getYear();
            }
        
        };
    }
    
    
    public ISalesReport<Sale> conditionByYear(Date value){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return value.getYear() == info.getDate().getYear();
            }
        
        };
    }
    
    
    public ISalesReport<Sale> conditionByCountServices(int value){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return value == info.getUser().getVehicles().getServicePackage().length;
            }
        
        };
    }
    
    
    public ISalesReport<Sale> conditionByCountAirFresher(){
        return new ISalesReport<Sale>(){
            @Override
            public boolean isInto(Sale info) {
                return info.determineAirFresher();
            }
        
        };
    }
    
    
    public IValue<Sale> contitionByValue(){
        return new IValue<Sale>(){
            @Override
            public int isInto(Sale info) {
                return info.getValue();
            }
        
        };
    }
    
    public String createDetailSalesReport(ISalesReport iSalesReport){
        String reportText = "";
        SalesReport salesReport = search(iSalesReport);
        salesReport.sortByValue();
        String countTotal = "Cantidad Total de ventas : "+ salesReport.getDatas().length +"\n";
        for(Object saleReport:salesReport.getDatas()){
            reportText += saleReport + "\n";
        }
        
        return reportText;
    }
    
    /**
     * Realizar una busqueda en base a los datos registrados para poder encontrar coincidencias con la
     * placa del vehiculo que se ingreso...
     * @param condition Cadena de caracteres --> Placa de un vehiculo...
     * @return Datos correspondientes al usuario vinculado a aquel vehiculo... 
     */
    public SalesReport searchByLicensePlate(String condition){
        return  search((ISalesReport<T>) conditionByLicensePlate(condition));
    }
    
    /**
     * Determinar la cantidad de veces que se ha utilizado cada servicio... 
     * @param condition Tipo de Servicio...
     * @return Contador de utilizacion del servicio...
     */
    public int countServices(int condition){
        return  count((ISalesReport<T>) conditionByCountServices(condition));
    }
    
    /**
     * Determinar la cantidad de veces que se ha entregado de obsequio un ambientador... 
     * @return Contador de ambientadores obsequiados...
     */
    public int countAirFresher(){
        return  count((ISalesReport<T>) conditionByCountAirFresher());
    }
    
    /**
     * Realizar una busqueda en base a los datos registrados para poder 
     * encontrar coincidencias de acuerdo a la fecha ingresada...
     * @param condition
     * @return 
     */
    public SalesReport searchByDate(Date condition){
        return  search((ISalesReport<T>) conditionByDate(condition));
    }
    
    public String createSalesReport(ISalesReport iSalesReport){
        SalesReport salesReport = search(iSalesReport);   
        String stringDate = "REPORTE POR PERIODO DE TIEMPO DIGITADO :  " + "\n";
        String stringByServices = "Cantidad de ventas con tres servicos : " + salesReport.countServices(3) + "\n" 
                + "Cantidad de ventas con dos servicos : " + salesReport.countServices(2) + "\n"
                + "Cantidad de ventas con un servico : " + salesReport.countServices(1) + "\n"
                + "Cantidad de usuarios que llevaron Ambientador : " + salesReport.countAirFresher() + "\n";
        String countTotal = "Total cantidad de ventas : "+ salesReport.getDatas().length +"\n";
        String totalValue = "Total recaudado : " + salesReport.countValue(contitionByValue()); 
        
        return stringDate + stringByServices + countTotal + totalValue;
    }
    
   
}
