package com.decodelabs.gradecalculator.service;

import java.util.List;

import com.decodelabs.gradecalculator.constant.AppConstants;
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

    public Grade calculateGrade(int mark) {
    	
    	
    	if (mark >= 80)
            return Grade.A_PLUS;

        if (mark >= 70)
            return Grade.A;

        if (mark >= 60)
            return Grade.A_MINUS;

        if (mark >= 50)
            return Grade.B;

        if (mark >= 40)
            return Grade.C;

        if (mark >= 33)
            return Grade.D;

        return Grade.F;
        
    }

   
    
    public boolean isPassed(List<SubjectMark> marks){

        for(SubjectMark mark : marks){

            if(mark.getMark()<AppConstants.PASS_MARK){

                return false;

            }

        }

        return true;

    }
    
    
    public boolean isDistinction(double average){

        return average >= 80;
    }
    
}
