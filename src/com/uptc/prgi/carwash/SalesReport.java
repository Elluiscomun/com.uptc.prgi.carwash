/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uptc.prgi.carwash;
import java.util.Comparator;

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
    
    public SalesReport searchByLicensePlate(String condition){
        return  search((ISalesReport<T>) conditionByLicensePlate(condition));
    }
}
