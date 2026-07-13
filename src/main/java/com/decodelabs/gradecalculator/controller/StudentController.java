package com.decodelabs.gradecalculator.controller;


import java.util.ArrayList;
import java.util.List;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.service.*;
import com.decodelabs.gradecalculator.ui.ConsoleUI;

public class StudentController {
	
	

    private final ConsoleUI consoleUI;

    private final ValidationService validationService;

    private final CalculationService calculationService;

    private final GradeService gradeService;
    
    

    public StudentController() {

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
        List<Integer> marks = new ArrayList<>();

//        Loop
        for (int i = 1; i <= subjectCount; i++) {

            int mark = consoleUI.readMark(i);

//            Validation
            while (!validationService.isValidMark(mark)) {

                consoleUI.showError("Marks must be between 0 and 100.");

                mark = consoleUI.readMark(i);
            }

//            Save   
            marks.add(mark);
        }

        
        
//        Create Student
        Student student = new Student();

        student.setName(studentName);
        student.setMarks(marks);

        
        
//        Total
        int total = calculationService.calculateTotal(student.getMarks());

//        Average
        double average = calculationService.calculateAverage(student.getMarks());

//        Grade
        String grade = gradeService.calculateGrade(average);
      
//        Pass
        boolean passed = gradeService.isPassed(student.getMarks());

        
        
//        GradeResult
        GradeResult result = new GradeResult();

        result.setTotalMarks(total);
        result.setAveragePercentage(average);
        result.setGrade(grade);
        result.setPassed(passed);

        
//        Show Result
        consoleUI.showResult(

                student.getName(),

                result.getTotalMarks(),

                result.getAveragePercentage(),

                result.getGrade(),

                result.isPassed()

        );
        
        
        //professional way::::
        //consoleUI.showResult(student, result);
        
        
//        Goodbye
        consoleUI.showGoodbye();
    }
    
    
   
    

}
