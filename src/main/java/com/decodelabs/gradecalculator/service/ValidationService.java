package com.decodelabs.gradecalculator.service;


public class ValidationService {
	
	

    public boolean isValidMark(int mark) {

        return mark >= 0 && mark <= 100;

    }

    public boolean isValidName(
            String name){

        return name!=null
                &&
                !name.trim().isEmpty();

    }

//    public boolean isValidSubjectCount(int subjectCount) { 	
//    	return false;
//    }
    
    
    
    public boolean isValidSubjectCount(int count){

    	 return count>0
    	            &&
    	            count<=20;

    }
     
}