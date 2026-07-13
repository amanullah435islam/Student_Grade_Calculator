package com.decodelabs.gradecalculator.ui;


import java.util.Scanner;

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
    
    
    
    
//    ✔ Ask Marks
    public int readMark(int subjectNumber){

        System.out.print(
                "Enter Marks for Subject "
                        + subjectNumber
                        + " : ");

        return scanner.nextInt();

    }
    
    
    
//   professional way: 
    
//    public void showResult(Student student,GradeResult result){

//}
    
    
    
//    ✔ Show Result
    public void showResult(
            String studentName,
            int total,
            double average,
            String grade,
            boolean passed){

        System.out.println();
        System.out.println("========== RESULT ==========");

        System.out.println("Student : " + studentName);

        System.out.println("Total : " + total);

        System.out.printf(
                "Average : %.2f%%\n",
                average);

        System.out.println("Grade : " + grade);

        System.out.println(
                "Status : "
                        + (passed ? "PASS" : "FAIL")
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
