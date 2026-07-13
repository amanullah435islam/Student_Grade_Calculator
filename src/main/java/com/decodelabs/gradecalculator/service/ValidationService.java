package com.decodelabs.gradecalculator.service;


public class ValidationService {

    public boolean isValidMark(int mark) {

        return mark >= 0 && mark <= 100;

    }

}