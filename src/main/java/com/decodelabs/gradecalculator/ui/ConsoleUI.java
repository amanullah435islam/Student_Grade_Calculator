package com.decodelabs.gradecalculator.ui;


import java.util.Scanner;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.util.InputHelper;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    
    
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

        return scanner.nextLine();

    }
    
    
    
    
//    ✔ Ask Subject Count
    public int readSubjectCount(){

        System.out.print("Enter Number of Subjects : ");

        return scanner.nextInt();

    }
    
    
    InputHelper inputHelper = new InputHelper () ;
    
//    ✔ Ask Marks
    public int readMark(int subjectNumber){

        System.out.print(
                "Enter Marks for Subject "
                        + subjectNumber
                        + " : ");
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
