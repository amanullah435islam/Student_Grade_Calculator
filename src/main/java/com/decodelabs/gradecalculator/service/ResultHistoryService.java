package com.decodelabs.gradecalculator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.decodelabs.gradecalculator.model.GradeResult;
import com.decodelabs.gradecalculator.model.Student;


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

				);

				writer.newLine();

				}
	}
	
	
//	List<GradeResult> ---->next work. :-
	public List<String> getAllResults() {

	    List<String> results = new ArrayList<>();

	    try (

	            BufferedReader reader =
	                    new BufferedReader(
	                            new FileReader("results.txt"))

	    ) {

	        String line;

	        while ((line = reader.readLine()) != null) {

	            results.add(line);

	        }

	    } catch (IOException e) {

	        e.printStackTrace();

	    }

	    return results;
	}
	    
}
