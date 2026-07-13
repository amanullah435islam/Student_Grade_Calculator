package com.decodelabs.gradecalculator.service;


import java.util.List;

public class CalculationService {
	
	

    public int calculateTotal(List<Integer> marks){

        int total = 0;

        for(Integer mark : marks){

            total += mark;

        }

        return total;

    }
    
    

//    public int calculateAverage(List<Integer> marks) {	
//    	return 0;
//    }
    
    
    
    public double calculateAverage(List<Integer> marks){

        int total =
                calculateTotal(marks);

        return (double) total /
                marks.size();

    }

    
}
