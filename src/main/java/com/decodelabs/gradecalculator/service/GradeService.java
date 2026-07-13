package com.decodelabs.gradecalculator.service;


public class GradeService {

    public String calculateGrade(double average){

        if(average>=80)
            return "A+";

        if(average>=70)
            return "A";

        if(average>=60)
            return "A-";

        if(average>=50)
            return "B";

        if(average>=40)
            return "C";

        if(average>=33)
            return "D";

        return "F";

    }

}
