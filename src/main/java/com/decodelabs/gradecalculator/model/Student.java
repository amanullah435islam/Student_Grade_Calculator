package com.decodelabs.gradecalculator.model;


import java.util.ArrayList;
import java.util.List;

public class Student {

	//Variable
    private String name;

    private List<Integer> marks;
    // List<Integer> use korci karon all subject alada vabe define korar need nai.
    
    //Default Constructor
    public Student() {
        this.marks = new ArrayList<>();
    }

    //Parameterized Constructor    
    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }
    
    
    
    
    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    
    
    
    
    // just test:
	public static void main(String[] args) {
	        
	    	
	     	Student student = new Student();
	
	    	student.setName("Aman");
	
	    	student.getMarks().add(90);
	    	student.getMarks().add(85);
	    	student.getMarks().add(75);
	    	student.getMarks().add(100);
	    	student.getMarks().add(80);
	    }




}





