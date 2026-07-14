package com.decodelabs.gradecalculator.service;

import java.util.List;
import com.decodelabs.gradecalculator.enumn.Grade;
import com.decodelabs.gradecalculator.model.SubjectMark;


public class GradeService {
	

    public Grade calculateGrade(double average){

        if(average>=80)
            return Grade.A_PLUS;

        if(average>=70)
            return Grade.A;

        if(average>=60)
            return Grade.A_MINUS;

        if(average>=50)
            return Grade.B;

        if(average>=40)
            return Grade.C;

        if(average>=33)
            return Grade.D;

        return Grade.F;

    }

    

    
// Only Pass/Fail::::::::
    
//    public boolean isPassed(double average){
//
//        return average>=33;
//
//    } 
    
    
    public boolean isPassed(List<SubjectMark> marks){

        for(SubjectMark mark : marks){

            if(mark.getMark()<33){

                return false;

            }

        }

        return true;

    }
    
    
}
