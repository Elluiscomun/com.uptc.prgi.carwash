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
    
<<<<<<< HEAD
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
=======
    public SalesReport(T[] datas) {
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
>>>>>>> e42dc43884cfde34c3fc40064bf4784519a7c54f
    }
    
}
