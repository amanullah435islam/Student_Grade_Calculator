package com.decodelabs.gradecalculator.model;

import com.decodelabs.gradecalculator.enumn.Grade;

public class GradeResult {
	

    private int totalMarks;

    private double averagePercentage;

    private Grade grade;

    private double gpa;

    private boolean passed;

    private boolean distinction;
    
    
    
    
    public GradeResult() {
    }

    
    public GradeResult(int totalMarks,
                       double averagePercentage,
                       Grade grade,
                       boolean passed) {

        this.totalMarks = totalMarks;
        this.averagePercentage = averagePercentage;
        this.grade = grade;
        this.passed = passed;
    }

    


	public GradeResult(int totalMarks, 
					   double averagePercentage, 
					   Grade grade, 
					   double gpa, 
					   boolean passed,
					   boolean distinction
					   ) {
		
		this.totalMarks = totalMarks;
		this.averagePercentage = averagePercentage;
		this.grade = grade;
		this.gpa = gpa;
		this.passed = passed;
		this.distinction = distinction;
	}


	public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public void setAveragePercentage(double averagePercentage) {
        this.averagePercentage = averagePercentage;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	public boolean isDistinction() {
		return distinction;
	}


	public void setDistinction(boolean distinction) {
		this.distinction = distinction;
	}
    

}


