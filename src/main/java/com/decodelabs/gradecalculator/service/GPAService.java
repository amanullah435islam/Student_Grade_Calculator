package com.decodelabs.gradecalculator.service;

public class GPAService {

    public double calculateGpa(double average){

        if(average >= 80)
            return 4.0;

        if(average >= 70)
            return 3.5;

        if(average >= 60)
            return 3.0;

        if(average >= 50)
            return 2.5;

        if(average >= 40)
            return 2.0;

        if(average >= 33)
            return 1.0;

        return 0.0;
    }

}
