package com.decodelabs.gradecalculator.model;

import com.decodelabs.gradecalculator.enumn.Grade;

public class GradeResult {
	

    private int totalMarks;

    private double averagePercentage;

    private Grade grade;

    private boolean passed;

    
    
    
    
    
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
    

}


