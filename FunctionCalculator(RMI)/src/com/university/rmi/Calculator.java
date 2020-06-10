package com.university.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Calculator extends Remote {
    List<Double> calculate(double a, double xFrom, double xTo, double step) throws RemoteException;
}
