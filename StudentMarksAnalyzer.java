
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//import classess from the java util package
import java.util.ArrayList; // Class to create resizable arrays for objects
import java.io.BufferedReader; // Class to read text from a character-input stream
import java.io.IOException; //This class is thrown when an I/O exception occurs
import java.util.Collections; // This class provides utility methods for working with collection
import java.util.Comparator; // This class provides utility methods for working with collection like list
import java.util.List; // represents an ordered collection of elements.

//Stores of each variable, represents the Student Class
class Student{
    String lastName;
    String firstName;
    String studentID;
    List<Double> marks; //Represents a list of the student's marks in various assignments
    double average; //Calculate average of Student's marks

    //Function designed to calculate the average of a list of marks, associated with a student
    public void calculateAverage(){
           double total = 0; //Initialize the sum of marks
           int count = 0; //Initialize for count the number of marks
           //
           for(double mark : marks){
                total += mark; //Add the current mark to the total sum
                count++; //Increment the count of marks
            }
            this.average = (count > 0) ? total / count: 0;
    }
    
   @Override
   public String ToString(){ //Constructs a string representation of the Student Object that have: lastName, firstName, marks
        return lastName + ", " + firstName + "(" + studentID + ") - Marks: " +marks+ " - Average: " + String.format("%.2f", average);
    }
    
    }
    
public class StudentMarksAnalyzer{

    public static void main(String[] args){
        String filename = "prog5001_students_grade_2022.txt";
        List<Student> students = readStudentData(filename);
        
        if(students.isEmpty){
            System.out.println("No valid student data found");
            return;
        }
    
    
    }







} 
    
    
    
    
    
    
    
    
    
    
    
    
    
    // @Override
    // //Method to format student inf into a string
    // public String toString(){
        
        // double totalMarks = getTotalMarks();        
        // return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f", lastName, firstName, studentID, A1, A2, A3, totalMarks);                             
    
    // }   
// }
// public class StudentOrder {
    // public static void main(String[] args){
    // //Scanner userInput = new Scanner(System.in);
    // ArrayList<Student> students = new ArrayList<>();
    
    // try{
       // File f = new File ("prog5001_students_grade_2022.txt"); //Creates a File object 
       // Scanner sc = new Scanner(f); // Creates a Scanner object to read the file
       
       // while (sc.hasNextLine()){ //Loop still until the end of the file
        // String line = sc.nextLine();
        // String[] parts = line.split(",");
        // //Assigns values from the split line to variables
        // String lastName = parts[0];
        // String firstName = parts[1];
        // String studentID = parts[2];
        
        // //Assigns values from the split line to variables
        // try{
        // float A1 = Float.parseFloat(parts[3]);
        // float A2 = Float.parseFloat(parts[4]);
        // float A3 = Float.parseFloat(parts[5]);
        
        // Student p = new Student(lastName, firstName, studentID, A1, A2, A3);//create a student object
        // students.add(p);
        
         // // Print for debugging
                    // System.out.println("Added student: " + p);
                // } catch (NumberFormatException e) {
                    // System.err.println("Error parsing grades for student: " + lastName + ", " + firstName + ", " + studentID);
                // }
            // }
        // } catch (FileNotFoundException e) {
            // e.printStackTrace();
            // System.err.println("File not found: " + e.getMessage());
        // }
    
        // students.sort((s1, s2) -> Float.compare(s2.getTotalMarks(), s1.getTotalMarks()));

        // System.out.println("\nTop 5 Students with Highest Marks: ");
        // for (int i = 0; i < Math.min(students.size(), 5); i++) { //print top 5 students with highest marks
            // System.out.println(students.get(i).toString());
        // }

        // System.out.println("\nTop 5 Students with Lowest Marks: ");
        // for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            // System.out.println(students.get(i).toString());
        // }
    // }          
    
    // }










   