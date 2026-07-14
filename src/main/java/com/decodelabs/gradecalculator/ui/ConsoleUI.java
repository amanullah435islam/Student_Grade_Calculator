package com.decodelabs.gradecalculator.ui;

import java.util.List;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.SubjectMark;
import com.decodelabs.gradecalculator.service.GradeService;
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
    
    
//  ✔ Ask Subject Name
    public String readSubjectName(
            int number){

        System.out.print(

                "Enter Subject "

                        + number

                        + " Name : "

        );

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
    public int readMark(int subject){

        int mark =
        		inputHelper.readInt(
        				"Enter Marks for "
                                + subject
                                + " : "
        		);

        return mark;

    }
   
    
    
    
//    ✔ Show Result
    public void showResult(Student student, GradeResult result) {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("             STUDENT REPORT CARD");
        System.out.println("==================================================");

        System.out.println();
        System.out.println("Student Name : " + student.getName());

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s%n",
                "Subject",
                "Marks",
                "Grade");
        System.out.println("--------------------------------------------------");

        GradeService gradeService = new GradeService();

        for (SubjectMark subject : student.getSubjectMarks()) {

            System.out.printf(
                    "%-15s %-10d %-10s%n",
                    subject.getSubjectName(),
                    subject.getMark(),
                    gradeService.calculateGrade(subject.getMark())
            );
        }

        System.out.println();
        System.out.println("--------------------------------------------------");

        System.out.printf("%-18s %d%n",
                "Total",
                result.getTotalMarks());

        System.out.printf("%-18s %.2f%%%n",
                "Average",
                result.getAveragePercentage());

        System.out.printf("%-18s %s%n",
                "Overall Grade",
                result.getGrade());

        System.out.printf("%-18s %s%n",
                "Status",
                result.isPassed() ? "PASS" : "FAIL");

        System.out.printf("%-18s %.2f%n",
                "GPA",
                result.getGpa());

        System.out.printf("%-18s %s%n",
                "Achievement",
                result.isDistinction()
                        ? "Distinction"
                        : "None");

        System.out.println();
        System.out.println("==================================================");
    }
    
    
    
//    ✔ Show Error
    public void showError(
            String message){

        System.out.println();

        System.out.println(
                "[ERROR] " + message
        );

    }
    
    
    
    public void showHistory(List<String> history) {
    	
    	System.out.println();

    	System.out.println(

    	"========= HISTORY ========="

    	);

    	for(String line : history){

    	System.out.println(line);

    	}
    }
    
    
    
//    ✔ Show Goodbye
    public void showGoodbye(){

        System.out.println();

        System.out.println(
                "Thank you for using Student Grade Calculator."
        );

    }
    
    

}
