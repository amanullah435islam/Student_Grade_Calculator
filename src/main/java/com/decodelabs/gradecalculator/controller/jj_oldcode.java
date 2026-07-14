package com.decodelabs.gradecalculator.controller;


import java.util.ArrayList;
import java.util.List;

import com.decodelabs.gradecalculator.enumn.Grade;
import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.SubjectMark;
import com.decodelabs.gradecalculator.service.*;
import com.decodelabs.gradecalculator.ui.ConsoleUI;

public class jj_oldcode {
	
	

    private final ConsoleUI consoleUI;

    private final ValidationService validationService;

    private final CalculationService calculationService;

    private final GradeService gradeService;
    
    

    public jj_oldcode() {

        consoleUI = new ConsoleUI();

        validationService = new ValidationService();

        calculationService = new CalculationService();

        gradeService = new GradeService();

    }
    
    
    
    
    public void start() {

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

        
        
//        Marks
        List<SubjectMark> SubjectMarks = new ArrayList<>();

//        Loop
        for (int i = 1; i <= subjectCount; i++) {

        	 String subjectName = consoleUI.readSubjectName(i);
            int mark = consoleUI.readMark(i);

//            Validation
            while (!validationService.isValidMark(mark)) {

                consoleUI.showError("Marks must be between 0 and 100.");

                mark = consoleUI.readMark(i);
            }
            
            // Create SubjectMark Object
            SubjectMark subjectMark = new SubjectMark();

            subjectMark.setSubjectName(subjectName);
            subjectMark.setMark(mark);

            // Add into List
            SubjectMarks.add(subjectMark);

        }

        
        
//        Create Student
        Student student = new Student();

        student.setName(studentName);
        student.setSubjectMarks(SubjectMarks);

        
        
//        Total
        int total = calculationService.calculateTotal(student.getSubjectMarks());

//        Average
        double average = calculationService.calculateAverage(student.getSubjectMarks());

//        Grade
        Grade grade = gradeService.calculateGrade(average);
      
//        Pass
        boolean passed = gradeService.isPassed(student.getSubjectMarks());

        
        
//        GradeResult
        GradeResult result = new GradeResult();

        result.setTotalMarks(total);
        result.setAveragePercentage(average);
        result.setGrade(grade);
        result.setPassed(passed);

        
//        Show Result
        consoleUI.showResult(student, result);
        
        
        
//        Goodbye
        consoleUI.showGoodbye();
    }
    
    
   
    

}
