package com.decodelabs.gradecalculator.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.decodelabs.gradecalculator.enumn.Grade;
import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.StudentResult;
import com.decodelabs.gradecalculator.model.SubjectMark;
import com.decodelabs.gradecalculator.service.*;
import com.decodelabs.gradecalculator.ui.ConsoleUI;

public class StudentController {
	
	

    private final ConsoleUI consoleUI;

    private final ValidationService validationService;

    private final CalculationService calculationService;

    private final GradeService gradeService;
    
    private final GPAService gpaService;
    
    private final ResultHistoryService resultHistoryService;
    //ResultHistoryService resultHistoryService = new ResultHistoryService();
    
    

    public StudentController() {

        consoleUI = new ConsoleUI();

        validationService = new ValidationService();

        calculationService = new CalculationService();

        gradeService = new GradeService();
        
        gpaService = new GPAService();
        
        resultHistoryService = new ResultHistoryService();

    }
    
    
    
    
    public void start() throws IOException {

//    	Welcome
        consoleUI.showWelcome();

        
//        Student Name
        String studentName = consoleUI.readStudentName();

        
        
//        Subject Count
        int subjectCount = consoleUI.readSubjectCount();
        //String subjectName = consoleUI.readSubjectName(subjectCount);

        
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
            while (!validationService.isValidMark(mark)) {

                consoleUI.showError("Marks must be between 0 and 100.");

                mark = consoleUI.readMark(i);
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
        
        
        List<StudentResult> history =
                resultHistoryService.getAllResults();

      
        
        
//        GradeResult
        GradeResult result = new GradeResult();

        result.setTotalMarks(total);
        result.setAveragePercentage(average);
        result.setGrade(grade);
        result.setPassed(passed);
        result.setGpa(gpa);
        result.setDistinction(distinction);

        
//        Show Result
        consoleUI.showResult(student, result);
        
        
//      result save:
        
        try {

            resultHistoryService.saveResult(student, result);

            System.out.println("Result Saved Successfully.");

        } catch (IOException e) {

            System.out.println("Save Failed.");

            e.printStackTrace();
        }

//      save result show :
      consoleUI.showHistory(history);
        
        
//        Goodbye
        consoleUI.showGoodbye();
        
        

        
    }
    
    
   
    

}
