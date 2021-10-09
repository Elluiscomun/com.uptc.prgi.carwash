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
public class SalesReport<T> {
        
    private T[] datas;
    
    public SalesReport(T[]datas){
        this.datas = datas;
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
    
}
