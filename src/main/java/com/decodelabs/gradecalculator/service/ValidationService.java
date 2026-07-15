package com.decodelabs.gradecalculator.service;

import com.decodelabs.gradecalculator.constant.AppConstants;
import com.decodelabs.gradecalculator.exception.InvalidMarkException;

public class ValidationService {
	
	

	public void validateMark(int mark)
	        throws InvalidMarkException {

	    if(mark < AppConstants.MIN_MARK || mark > AppConstants.MAX_MARK) {

	        throw new InvalidMarkException(
	                "Marks must be between 0 and 100."
	        );

	    }

	}
    
    

    public boolean isValidName(
            String name){

        return name!=null
                &&
                !name.trim().isEmpty();

    }

    
    
    public boolean isValidSubjectCount(int count){

    	 return count>0
    	            &&
    	            count<=20;

    }
     
}