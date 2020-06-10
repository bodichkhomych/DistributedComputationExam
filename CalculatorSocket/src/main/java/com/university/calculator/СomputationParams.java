package com.university.calculator;

import java.io.Serializable;

public class СomputationParams implements Serializable {
    public double a,xFom,xTo,step;

    public СomputationParams(double a, double xFom, double xTo, double step) {
        this.a = a;
        this.xFom = xFom;
        this.xTo = xTo;
        this.step = step;
    }
}
