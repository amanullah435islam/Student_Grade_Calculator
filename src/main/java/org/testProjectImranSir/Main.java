package org.testProjectImranSir;


import java.io.IOException;

import com.decodelabs.gradecalculator.controller.StudentController;

public class Main {

    public static void main(String[] args) {

        StudentController controller =
                new StudentController();

        try {
			controller.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}