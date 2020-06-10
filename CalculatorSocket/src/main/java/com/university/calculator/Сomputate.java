package com.university.calculator;

import java.rmi.Remote;
import java.util.List;

public interface Сomputate extends Remote {
    List<Double> calculate(double a, double xFrom, double xTo, double step);
}
