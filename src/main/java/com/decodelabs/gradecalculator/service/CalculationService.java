package com.decodelabs.gradecalculator.service;


import java.util.List;

import com.decodelabs.gradecalculator.model.SubjectMark;

public class CalculationService {
	
	

    public int calculateTotal(List<SubjectMark> marks){

        int total = 0;

        for(SubjectMark subject : marks){

            total += subject.getMark();

        }

        return total;

    }
    
    
    
    
    public double calculateAverage(List<SubjectMark> marks){

        int total =
                calculateTotal(marks);

        return (double) total /
                marks.size();

    }

    
}
