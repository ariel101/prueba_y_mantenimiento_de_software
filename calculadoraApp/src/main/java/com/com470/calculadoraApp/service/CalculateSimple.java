package com.com470.calculadoraApp.service;

import com.com470.calculadoraApp.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateSimple {
    public int add(OperationModel model){
        return model.getA() + model.getB();
    }

    public int subtract(OperationModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

    public int factorial(OperationModel model) {
        return factorial(model.getC());
    }

    private int factorial(int n){
        return n < 2 ? n : n * factorial(n-1);
    }

    public int fibonacci(OperationModel model){
        return fibonacci(model.getC());
    }

    private int fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public double sqrt(OperationModel model){
        return Math.sqrt(model.getC());
    }

    public int power(OperationModel model){
        return model.getC() * model.getC();
    }

    public OperationModel clearSimple(OperationModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }

    public OperationModel clearAdvanced(OperationModel model){
        model.setC(0);
        return model;
    }

}
