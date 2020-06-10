package com.university.calculator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Сomputation implements Сomputate {
    public Сomputation() throws RemoteException {
        super();
    }

    private double function(double a,double x){
        return Math.tan(x) - a;
    }

    @Override
    public synchronized List<Double> calculate(double a, double xFrom, double xTo, double step) {
        ArrayList<Double> results = new ArrayList<>();
        for(double t = xFrom; t <=xTo; t+=step){
            results.add(function(a,t));
        }
        return results;
    }
}
