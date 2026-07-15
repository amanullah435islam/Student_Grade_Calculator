package com.decodelabs.gradecalculator.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.decodelabs.gradecalculator.enumn.Grade;
import com.decodelabs.gradecalculator.exception.InvalidMarkException;
import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.StudentResult;
import com.decodelabs.gradecalculator.model.SubjectMark;
import com.decodelabs.gradecalculator.service.*;
import com.decodelabs.gradecalculator.ui.ConsoleUI;

public class StudentController {
	
	private static final Logger LOGGER =
	        Logger.getLogger(
	                StudentController.class.getName()
	        );

	
    private final ConsoleUI consoleUI;

    private final ValidationService validationService;

    private final CalculationService calculationService;

    private final GradeService gradeService;
    
    private final GPAService gpaService;
    
    private final ResultHistoryService resultHistoryService;
    
    private final AnalyticsService analyticsService;
    

    public StudentController() {

        consoleUI = new ConsoleUI();

        validationService = new ValidationService();

        calculationService = new CalculationService();

        gradeService = new GradeService();
        
        gpaService = new GPAService();
        
        resultHistoryService = new ResultHistoryService();

        analyticsService = new AnalyticsService();
    }
    
    
    
    
    public void start() throws IOException {

//    	Welcome
        consoleUI.showWelcome();

        
//        Student Name
        String studentName = consoleUI.readStudentName();

        
        
//        Subject Count
        int subjectCount = consoleUI.readSubjectCount();
       
        
//        Validation 
        while (!validationService.isValidSubjectCount(subjectCount)) {

            consoleUI.showError("Subject count must be greater than zero.");

            subjectCount = consoleUI.readSubjectCount();
        }

        
     // Subject Marks
        List<SubjectMark> subjectMarks = new ArrayList<>();

        // Loop
        for (int i = 1; i <= subjectCount; i++) {

            // Read Subject Name
            String subjectName = consoleUI.readSubjectName(i);

            // Read Mark
            int mark = consoleUI.readMark(i);

            // Validation            
            try {

                validationService.validateMark(mark);

            } catch (InvalidMarkException ex) {

                consoleUI.showError(ex.getMessage());

            }

            // Create SubjectMark Object
            SubjectMark subjectMark = new SubjectMark();

            subjectMark.setSubjectName(subjectName);
            subjectMark.setMark(mark);

            // Add into List
            subjectMarks.add(subjectMark);
        }
        
        
//        Create Student
        Student student = new Student();

        student.setName(studentName);
        student.setSubjectMarks(subjectMarks);

        
        
//        Total
        int total = calculationService.calculateTotal(student.getSubjectMarks());

//        Average
        double average = calculationService.calculateAverage(student.getSubjectMarks());

//        Grade
        Grade grade = gradeService.calculateGrade(average);
      
//        Pass
        boolean passed = gradeService.isPassed(student.getSubjectMarks());

        double gpa =
                gpaService.calculateGpa(average);
        
        boolean distinction =
                gradeService.isDistinction(average);
        
        List<StudentResult> results =
                resultHistoryService.getAllResults();

        
        
//      // specialized code - 3 (using history)
        
        String name =
                consoleUI.readSearchName();       

        List<StudentResult> history =
                resultHistoryService.getAllResults();

        StudentResult students =
                analyticsService.searchByName(history,name);

        consoleUI.showSearchResult(students);
        
           
//		// specialized code - 4 (using history)
        StudentResult highest =
                analyticsService.getTopStudent(history);

        StudentResult lowest =
                analyticsService.getLowestStudent(history);

        double averages =
                analyticsService.getClassAverage(history);

        double passRate =
                analyticsService.getPassRate(history);

        double failRate =
                analyticsService.getFailRate(history);

        consoleUI.showStatistics(

                highest,

                lowest,

                average,

                passRate,

                failRate

        );
        
        
        
        
//      // specialized code - 5 (using history)
        
        List<StudentResult> topFive =
                analyticsService.getTopStudents(history,5);

        consoleUI.showLeaderboard(topFive);
        
        
     
        
        
        
        
//        GradeResult
        GradeResult result = new GradeResult();

        result.setTotalMarks(total);
        result.setAveragePercentage(average);
        result.setGrade(grade);
        result.setPassed(passed);
        result.setGpa(gpa);
        result.setDistinction(distinction);

        
//       Show Result
        consoleUI.showResult(student, result);
        
        
//      result save & specialized code
        
        try {

            resultHistoryService.saveResult(student, result);
             
            // Developer Log
            LOGGER.info("Result Saved Successfully.");

//          // User Message
//            System.out.println("Result Saved Successfully.");

        } catch (IOException e) {
     
            LOGGER.severe("Failed to save result : " + e.getMessage());
            
            //e.printStackTrace();
        }

        
        
//      save result show & specialized code - 2 (using history)
        
      consoleUI.showHistory(history);
        
      
  
      
      
      
      
        
//        Goodbye
        consoleUI.showGoodbye();
        
        

        
    }
    
    
   
    

}
