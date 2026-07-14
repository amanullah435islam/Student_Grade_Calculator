package com.decodelabs.gradecalculator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.decodelabs.gradecalculator.enumn.Grade;
import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;
import com.decodelabs.gradecalculator.model.StudentResult;


public class ResultHistoryService {
	
	
	public void saveResult(Student student, GradeResult result) throws IOException {
		
		
		try(

				BufferedWriter writer =

				new BufferedWriter(

				new FileWriter(

				"results.txt",

				true

				)

				)

				){

			writer.write(

					student.getName()

					+ ","

					+ result.getTotalMarks()

					+ ","

					+ result.getAveragePercentage()

					+ ","

					+ result.getGrade()

					+ ","

					+ result.isPassed()

					+ ","

					+ result.getGpa()

					+ ","

					+ LocalDateTime.now()

					);

				writer.newLine();

				}
	}
	
	
//	List<GradeResult> ---->next work. :-
	public List<StudentResult> getAllResults() {

	    List<StudentResult> results = new ArrayList<>();

	    try (BufferedReader reader =
	                 new BufferedReader(new FileReader("results.txt"))) {

	        String line;

	        while ((line = reader.readLine()) != null) {

	            String[] data = line.split(",");

	            Student student = new Student();
	            student.setName(data[0]);

	            GradeResult gradeResult = new GradeResult();
	            gradeResult.setTotalMarks(Integer.parseInt(data[1]));
	            gradeResult.setAveragePercentage(Double.parseDouble(data[2]));
	            gradeResult.setGrade(Grade.valueOf(data[3]));
	            gradeResult.setPassed(Boolean.parseBoolean(data[4]));
	            gradeResult.setGpa(Double.parseDouble(data[5]));

	            StudentResult result = new StudentResult();

	            result.setStudent(student);
	            result.setGradeResult(gradeResult);
	            
	            if (data.length > 6) {

	                result.setGeneratedAt(
	                        LocalDateTime.parse(data[6]));

	            }
	            results.add(result);

	        }

	    } catch (IOException e) {

	        e.printStackTrace();

	    }

	    return results;
	}	    
}
