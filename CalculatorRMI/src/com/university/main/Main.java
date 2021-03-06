package com.university.main;

import com.university.client.RmiClient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program is calculating the function: tan(x) - a");
        double a, xFrom, xTo, step;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter main value: ");
        a = in.nextFloat();
        System.out.print("Enter begin x value: ");
        xFrom = in.nextFloat();
        System.out.print("Enter finished x value: ");
        xTo = in.nextFloat();
        System.out.print("Enter calculation step: ");
        step = in.nextFloat();

        try {
            RmiClient rmiClient = new RmiClient();
            List<Double> results = rmiClient.calculate(a,xFrom,xTo,step);
            int i = 0;
            for (double t = xFrom; t<=xTo; t+=step){
                System.out.println("|" + t + "|" + results.get(i) + "|");
                i++;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
