package com.decodelabs.gradecalculator.service;

import java.util.List;
import com.decodelabs.gradecalculator.enumn.Grade;


public class GradeService {
	

    public String calculateGrade(double average){

        if(average>=80)
            return Grade.A_PLUS.toString();

        if(average>=70)
            return Grade.A.toString();

        if(average>=60)
            return Grade.A_MINUS.toString();

        if(average>=50)
            return Grade.B.toString();

        if(average>=40)
            return "C";

        if(average>=33)
            return "D";

        return "F";

    }

    

    
// Only Pass/Fail::::::::
    
//    public boolean isPassed(double average){
//
//        return average>=33;
//
//    } 
    
    
    public boolean isPassed(List<Integer> marks){

        for(Integer mark : marks){

            if(mark<33){

                return false;

            }

        }

        return true;

    }
    
    
}
