package com.decodelabs.gradecalculator.service;



import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.decodelabs.gradecalculator.model.StudentResult;

public class AnalyticsService {

    public StudentResult searchByName(List<StudentResult> students,
                                      String name) {
    	  	
    	return students.stream()

    	        .filter(s ->

    	                s.getStudent()

    	                        .getName()

    	                        .equalsIgnoreCase(name))

    	        .findFirst()

    	        .orElse(null);
    	
    	
    }

    
    
    
    
    
    
    public StudentResult getTopStudent(List<StudentResult> students) {
    	StudentResult top = students.get(0);

    	for(StudentResult s : students){

    	    if(s.getGradeResult()

    	            .getAveragePercentage()

    	            >

    	            top.getGradeResult()

    	                    .getAveragePercentage()){

    	        top = s;

    	    }

    	}

    	return top;
    }

    
    
    
    
    
    
    public StudentResult getLowestStudent(List<StudentResult> students) {
    	StudentResult top = students.get(0);

    	for(StudentResult s : students){

    	    if(s.getGradeResult()

    	            .getAveragePercentage()

    	            <

    	            top.getGradeResult()

    	                    .getAveragePercentage()){

    	        top = s;

    	    }

    	}

    	return top;
    }

    
    
    
    
    
    
    public double getClassAverage(List<StudentResult> students) {
    	double total = 0;

    	for(StudentResult s : students){

    	    total +=

    	            s.getGradeResult()

    	                    .getAveragePercentage();

    	}

    	return total / students.size();
    }

    
    
    
    
    
    
    
    public double getPassRate(List<StudentResult> students) {
    	int pass = 0;

    	for(StudentResult s : students){

    	    if(s.getGradeResult()

    	            .isPassed()){

    	        pass++;

    	    }

    	}

    	return

    	(pass * 100.0)

    	/ students.size();
    }

    
    
    
    
    
    public double getFailRate(List<StudentResult> students) {
    	return 100 - getPassRate(students);
    }
    
    
    
    
    

    public List<StudentResult> getTopStudents(List<StudentResult> students,
                                              int limit) {
    	Collections.sort(

    			students,

    			Comparator

    			.comparingDouble(

    			r ->
//cust
    			((StudentResult) r).getGradeResult()

    			.getAveragePercentage())

    			.reversed()

    			);
    	
    	
    	
    	
    	return students

    			.subList(

    			0,

    			Math.min(limit,

    			students.size())

    			);
    }
}


