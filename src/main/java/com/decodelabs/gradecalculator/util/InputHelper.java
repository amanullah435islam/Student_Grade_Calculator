package com.decodelabs.gradecalculator.util;


import java.util.Scanner;

public class InputHelper {

    private final Scanner scanner;

    public InputHelper() {

        scanner = new Scanner(System.in);

    }

    public int readInt(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();

                scanner.nextLine();

                return value;

            }

            System.out.println(
                    "Invalid number. Please try again."
            );

            scanner.nextLine();

        }

    }
    
    public String readString(String message) {   	
    	 
    	System.out.print(message);
    	return scanner.nextLine();
    }

}




