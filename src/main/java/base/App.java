/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 18 - Temperature Converter

You’ll often need to determine which part of a program is run based on user input or other events.

Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for the starting temperature. The program should prompt for the type of conversion and then perform the conversion.

The formulas are

C = (F − 32) × 5 / 9

and

F = (C × 9 / 5) + 32

Example Output

Press C to convert from Fahrenheit to Celsius.
Press F to convert from Celsius to Fahrenheit.
Your choice: C
Please enter the temperature in Fahrenheit: 32
The temperature in Celsius is 0.
Constraints

    Ensure that you allow upper or lowercase values for C and F.
    Use as few output statements as possible and avoid repeating output strings.

Challenges

    Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
    Break the program into functions that perform the computations.
    Implement this program as a GUI program that automatically updates the values when any value changes.
    Modify the program so it also supports the Kelvin scale.

 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String type = myApp.typeOfTemp();
        int temp = myApp.currentTemp(type);
        int convert = myApp.conversion(type, temp);
        String outputString = myApp.generateOutputString(type, convert);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public String typeOfTemp() {
        String temp = "";
        int check = 0;
        while(check == 0){
            System.out.println("Press C to convert from Fahrenheit to Celsius.\n" +
                    "Press F to convert from Celsius to Fahrenheit.");
            switch (in.nextLine()) {
                case "F", "f" -> {
                    temp = "F";
                    check = 1;
                    System.out.println("Your choice: F");
                }
                case "C", "c" -> {
                    temp = "C";
                    check = 1;
                    System.out.println("Your choice: C");
                }
                default -> System.out.println("That's not a valid temperature type.");
            }
        }

        return temp;
    }

    public int currentTemp(String type) {
        if(type.equals("C")){
            System.out.println("Please enter the temperature in Fahrenheit: ");
        }else{
            System.out.println("Please enter the temperature in Celsius: ");
        }
        return in.nextInt();
    }

    public int conversion(String type, int temp) {
        int a, b, c;
        if(type.equals("C")){
            a = temp - 32;
            b = a * 5;
            c = b / 9;
        }else{
            a = temp * 9;
            b = a / 5;
            c = b + 32;
        }
        return c;
    }

    public String generateOutputString(String type, int convert) {
        if(type.equals("C")) {
            return "The temperature in Celsius is " + convert + ".";
        }else{
            return "The temperature in Fahrenheit is " + convert + ".";
        }
    }
}
