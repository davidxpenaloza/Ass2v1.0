
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*; //Imports classes for input/output
import java.util.ArrayList; //Imports the ArrayList class for storing
import java.util.Scanner; // Imports the Scanner class for reading user input

//Stores of each variable, student data
class Student{
    private String lastName; 
    private String firstName;
    private String studentID;
    private float A1;
    private float A2;
    private float A3;

    //Method to calculate and return total marks
    public float getTotalMarks(){
           return (A1 + A2 + A3)/3; // Returns the sum of assignment scores
    }
    
    public Student(String lastName, String firstname, String studentID, float A1, float A2, float A3){
     //Assigns values to instance variables using "this"
     this.lastName = lastName;
     this.firstName = firstName;
     this.studentID = studentID;
     this.A1 = A1;
     this.A2 = A2;
     this.A3 = A3;
    }
    @Override
    //Method to format student inf into a string
    public String toString(){
        
        double totalMarks = getTotalMarks();        
        return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f", lastName, firstName, studentID, A1, A2, A3, totalMarks); // Returns formatted string of student details                            
    
    }   
}
public class StudentOrder {
    public static void main(String[] args){
    //Scanner userInput = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    
    try{// Creates a File object pointing to the specified file
       File f = new File ("prog5001_students_grade_2022.txt"); //Creates a File object 
       Scanner sc = new Scanner(f); // Creates a Scanner object to read the file
       
       while (sc.hasNextLine()){ //Loop still until the end of the file
        String line = sc.nextLine();
        String[] parts = line.split(",");
        //Assigns values from the split line to variables
        String lastName = parts[0];
        String firstName = parts[1];
        String studentID = parts[2];
        
        //Assigns values from the split line to variables
        try{
        float A1 = Float.parseFloat(parts[3]);
        float A2 = Float.parseFloat(parts[4]);
        float A3 = Float.parseFloat(parts[5]);
        
        Student p = new Student(lastName, firstName, studentID, A1, A2, A3);//create a student object
        students.add(p);
        
         // Print for debugging
                    System.out.println("Added student: " + p);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing grades for student: " + lastName + ", " + firstName + ", " + studentID);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Outputs stack trace of the error
            System.err.println("File not found: " + e.getMessage());
        }
    
        students.sort((s1, s2) -> Float.compare(s2.getTotalMarks(), s1.getTotalMarks())); // Sorts the students list based on total marks in descending order
       
       // Prints each of the top 5 students' information
       
       // Outputs the top 5 students with the highest marks
        System.out.println("\nTop 5 Students with Highest Marks: ");
        for (int i = 0; i < Math.min(students.size(), 5); i++) { //print top 5 students with highest marks
            System.out.println(students.get(i).toString());
        }
        // Outputs the top 5 students with the lowest marks
        System.out.println("\nTop 5 Students with Lowest Marks: ");
        for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            System.out.println(students.get(i).toString());
        }
    }          
    
    }










   