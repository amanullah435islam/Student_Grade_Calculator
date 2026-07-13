package com.decodelabs.gradecalculator.ui;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.util.InputHelper;

public class ConsoleUI {

	InputHelper inputHelper = new InputHelper () ;

	

//    ✔ Welcome Screen
    public void showWelcome() {

        System.out.println("======================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("======================================");
        System.out.println();

    }
    
    
    
    
    
//    ✔ Ask Student Name
    public String readStudentName(){
    	System.out.print("Enter Student Name : ");
    	String r = inputHelper.readString("Enter Student Name : ");
    	
    	return r;
        
    }
    
    
    
    
//    ✔ Ask Subject Count
    public int readSubjectCount(){      
        
        int count =
        		inputHelper.readInt(
        				"Enter Number of Subjects : "
        		);

        return count;

    }
    
    
    
    
//    ✔ Ask Marks
    public int readMark(int subjectNumber){

        int mark =
        		inputHelper.readInt(
        				"Enter Marks for Subject "
                                + subjectNumber
                                + " : "
        		);

        return mark;

    }
    
    
    
//   professional way: 
    
//    public void showResult(Student student,GradeResult result){

//}
    
    
    
//    ✔ Show Result
    public void showResult(

Student student,

GradeResult result

){

        System.out.println();
        System.out.println("========== RESULT ==========");

        System.out.println(
                "Student : "
                + student.getName()
        );

        System.out.println(
                "Grade : "
                + result.getGrade()
        );

    }
    
    
    
//    ✔ Show Error
    public void showError(
            String message){

        System.out.println();

        System.out.println(
                "[ERROR] " + message
        );

    }
    
    
    
//    ✔ Show Goodbye
    public void showGoodbye(){

        System.out.println();

        System.out.println(
                "Thank you for using Student Grade Calculator."
        );

    }
    
    

}
