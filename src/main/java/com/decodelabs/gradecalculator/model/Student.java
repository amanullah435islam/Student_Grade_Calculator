package com.decodelabs.gradecalculator.model;


import java.util.ArrayList;
import java.util.List;

public class Student {

	//Variable
    private String name;

    private List<SubjectMark> subjectMarks;
    
    
    
    //Default Constructor
    public Student() {
        this.subjectMarks = new ArrayList<>();
    }
   
    
    // Getter & Setter
    public String getName() {
        return name;
    }

    public Student(String name, List<SubjectMark> subjectMarks) {
		super();
		this.name = name;
		this.subjectMarks = subjectMarks;
	}


	public void setName(String name) {
        this.name = name;
    }


	public List<SubjectMark> getSubjectMarks() {
		return subjectMarks;
	}


	public void setSubjectMarks(List<SubjectMark> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

    
}





