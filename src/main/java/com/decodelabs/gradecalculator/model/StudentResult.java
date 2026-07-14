package com.decodelabs.gradecalculator.model;

import java.time.LocalDateTime;

public class StudentResult {

    private Student student;

    private GradeResult gradeResult;

    private LocalDateTime generatedAt;

    
    
    
	public StudentResult() {
		super();
	}




	public StudentResult(Student student, GradeResult gradeResult, LocalDateTime generatedAt) {
		super();
		this.student = student;
		this.gradeResult = gradeResult;
		this.generatedAt = generatedAt;
	}

	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public GradeResult getGradeResult() {
		return gradeResult;
	}

	public void setGradeResult(GradeResult gradeResult) {
		this.gradeResult = gradeResult;
	}

	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}
    
    
    

}
