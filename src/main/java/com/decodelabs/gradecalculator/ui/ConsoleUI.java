package com.decodelabs.gradecalculator.ui;

import java.util.List;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.StudentResult;
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
    	
    	String r = inputHelper.readString("Enter Student Name : ");
    	
    	return r;
        
    }
    
    
//  ✔ Ask Subject Name
    public String readSubjectName(
            int number){

        String r = inputHelper.readString(
        		
        		"Enter Subject "

                        + number

                        + " Name : "
        		
        		);
    	
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
    
    
    
    public void showHistory(List<StudentResult> history) {

        System.out.println();

        System.out.println("=========== HISTORY ===========");

        for (StudentResult result : history) {

            System.out.println("----------------------------");

            System.out.println(
                    "Student : "
                            + result.getStudent().getName()
            );

            System.out.println(
                    "Total : "
                            + result.getGradeResult().getTotalMarks()
            );

            System.out.println(
                    "Average : "
                            + result.getGradeResult().getAveragePercentage()
            );

            System.out.println(
                    "Grade : "
                            + result.getGradeResult().getGrade()
            );

            System.out.println(
                    "GPA : "
                            + result.getGradeResult().getGpa()
            );

            System.out.println(
                    "Date : "
                            + result.getGeneratedAt()
            );

        }

    }
    
    
   
    
//    ✔ Show Goodbye
    public void showGoodbye(){

        System.out.println();

        System.out.println(
                "Thank you for using Student Grade Calculator."
        );

    }





	


    public void showLeaderboard(List<StudentResult> students) {

        System.out.println();
        System.out.println("========= TOP STUDENTS =========");

        int rank = 1;

        for (StudentResult student : students) {

            System.out.println(rank + ".");

            System.out.println("Name : "
                    + student.getStudent().getName());

            System.out.println("Average : "
                    + student.getGradeResult().getAveragePercentage());

            System.out.println("Grade : "
                    + student.getGradeResult().getGrade());

            System.out.println("---------------------------");

            rank++;
        }
    }

    public void showStatistics(
            StudentResult highest,
            StudentResult lowest,
            double classAverage,
            double passRate,
            double failRate) {

        System.out.println();
        System.out.println("========= CLASS STATISTICS =========");

        System.out.println("Highest Student : "
                + highest.getStudent().getName());

        System.out.println("Lowest Student : "
                + lowest.getStudent().getName());

        System.out.printf("Class Average : %.2f%%%n",
                classAverage);

        System.out.printf("Pass Rate : %.2f%%%n",
                passRate);

        System.out.printf("Fail Rate : %.2f%%%n",
                failRate);

    }

    
    
    public void showSearchResult(StudentResult student) {

        if (student == null) {

            System.out.println();
            System.out.println("Student not found.");
            return;

        }

        System.out.println();
        System.out.println("========== SEARCH RESULT ==========");

        System.out.println("Student : "
                + student.getStudent().getName());

        System.out.println("Total : "
                + student.getGradeResult().getTotalMarks());

        System.out.println("Average : "
                + student.getGradeResult().getAveragePercentage());

        System.out.println("Grade : "
                + student.getGradeResult().getGrade());

        System.out.println("GPA : "
                + student.getGradeResult().getGpa());

        System.out.println("Status : "
                + (student.getGradeResult().isPassed() ? "PASS" : "FAIL"));

    }
    
   
    
    public String readSearchName() {

        return inputHelper.readString("Enter Student Name to Search : ");

    }
    
    

}
