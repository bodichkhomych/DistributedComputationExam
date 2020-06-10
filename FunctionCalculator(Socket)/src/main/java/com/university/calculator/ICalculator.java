package com.university.calculator;

import java.rmi.Remote;
import java.util.List;

public interface ICalculator extends Remote {
    List<Double> calculate(double a, double xFrom, double xTo, double step);
}
