package com.decodelabs.gradecalculator.model;


public class GradeResult {
	

    private int totalMarks;

    private double averagePercentage;

    private String grade;

    private boolean passed;

    
    
    
    
    
    public GradeResult() {
    }

    
    public GradeResult(int totalMarks,
                       double averagePercentage,
                       String grade,
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
    

}


