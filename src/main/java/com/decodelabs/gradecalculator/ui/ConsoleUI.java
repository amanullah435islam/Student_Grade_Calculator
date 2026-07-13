package com.decodelabs.gradecalculator.ui;


import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void showWelcome() {

        System.out.println("======================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("======================================");
        System.out.println();

    }
    
    
    
    public String readStudentName(){

        System.out.print("Enter Student Name : ");

        return scanner.nextLine();

    }
    
    
    public int readSubjectCount(){

        System.out.print("Enter Number of Subjects : ");

        return scanner.nextInt();

    }
    
    
    
    public int readMark(int subjectNumber){

        System.out.print(
                "Enter Marks for Subject "
                        + subjectNumber
                        + " : ");

        return scanner.nextInt();

    }
    
    
    
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
    
    
    public void showError(
            String message){

        System.out.println();

        System.out.println(
                "[ERROR] " + message
        );

    }
    
    
    
    public void showGoodbye(){

        System.out.println();

        System.out.println(
                "Thank you for using Student Grade Calculator."
        );

    }
    
    

}
