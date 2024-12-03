
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Import the requisite libraries for file management, scanning, and string manipulation.
import java.io.*;
import java.io.File; //Import the File class
import java.io.FileNotFoundException; //Import this class to handle errors
import java.util.Scanner; //Import the Scanner class to read text files
import java.util.ArrayList;

//Define the Student class to encapsulate the details and academic performance of an individual student.
class Student {
    // Instance variables for the purpose of storing student information."
    private String lastName;
    private String firstName;
    private String studentID;
    private float A1;
    private float A2;
    private float A3;

    /**
     * Constructor to instantiate a Student object with the specified details.
     */
  public Student(String LastName, String FirstName, String StudentID, float A1, float A2, float A3)
    {
       
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
       
    }

    //Empty constructor
  public Student(){
    }  
    
    //Method to calculate the final grade (average A1, A2, A3)
    public double getNotaFinal(){
    return (A1 + A2 + A3) / 3.; //"Utilizing a double data type here to accommodate a potentially broader range of grades."
    }
     //Accessor methods to retrieve student information
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getStudentID(){
        return studentID;
    }
    

    /**
     * methods to access the properties
     */
    //Accessor methods to retrieve individual grades
    public float getA1(){
        return A1;
    }
    
    public float getA2(){
        return A2;
    }

    public float getA3(){
        return A3;
    }
     
   //Procedures for establishing student information with validation for the lenght of names.
  public boolean setLastName(String lastName){
    
    if ((lastName.length() > 2) && (lastName.length() < 30)){
             this.lastName = lastName;
        } else{
            return false; //Invalid name length
        }
        return true;
    }

    public boolean setFirstName(String firstName){
    
        if ((firstName.length() > 2) && (firstName.length() < 20)){
            this.firstName = firstName;
        } else{
            return false; //Invalid name length
        }
        return true;
    }
    
    public boolean setStudentID(String studentID){
    
        if ((studentID.length() > 2) && (studentID.length() < 10)){
            this.studentID = studentID;
        } else{
            return false; //Invalid name length
        }
        return true;
    }
    
    //Methods to set individual grades with validation for grade range
    public boolean seta1(float A1){
    
        if( (A1>0) && (A1<30)){
            this.A1 = A1;
        }else {
            return false; //Invalid name length
        }
        return true;
    }
    
    public boolean seta2(float A2){
    
        if( (A2>0) && (A2<30)){
            this.A2 = A2;
        }else {
            return false;//Invalid name length
        }
        return true;
    }
    
    public boolean seta3(float A3){
    
        if( (A3>0) && (A3<30)){
            this.A3 = A3;
        }else {
            return false; //Invalid name length
        }
        return true;
    }
     //Override the toString() method to format student information into a string
    @Override
    public String toString(){
        double notaFinal =getNotaFinal(); // Calculate and store final grade
        //float notaFinal = getNotaFinal();
        return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f", lastName, firstName, studentID, A1, A2, A3, notaFinal);                             
    
    }
}
   // Define the StudentMarks class containing the main method
    public class StudentMarks{
    // Define the main method        
   public static void main (String[] args){
       //Scanner object utilized to obtain user input for the minimum threshold of total marks
       Scanner userInput = new Scanner(System.in);
       System.out.print("Enter the minimun total mark threshold: ");
       float threshold = userInput.nextFloat();
       
    //Try-catch block to handle potential file not found exceptions
       
        try{
           //Establish a File object that corresponds to the student grade data file
           File f = new File ("prog5001_students_grade_2022.txt");
           Scanner sc = new Scanner(f); //create a scanner object to read from the file
           //counter cariable to keep track of lines processed (Excluding header)
           int i=0;
           // Loop continues as long as there's another line in the line
           while(sc.hasNextLine()){
               //Initialize variables to store student information
               String s = sc.nextLine();
               //Process lines only after the header
               if (i == 0){
                i++;
                continue;// Move to the next iteration without processing this line
              }
               
                String[] details = s.split(","); // Split the line into an array of strings using commas as delimiters
                
                if(details.length < 6){  // Check if the line has less than 6 elements
                    System.out.println("Malformed line: "+s); // Print error
                    continue;
                }
                
                
                //Extract student information from the split details
                String lastName = details[0].trim();//Extract lastName, trim any whitespace
                String firstName = details[1].trim();//Extract firstName, trim any whitespace
                String studentID = details[2].trim();//Extract studentName, trim any whitespace
                // Initialize variables for the purpose of storing student grades.

                float A1 = parseGrade(details[3].trim());
                float A2 = parseGrade(details[4].trim());
                float A3 = parseGrade(details[5].trim());
                
                float totalMarks = (A1+A2+A3)/3;  // Calculate the total marks by averaging grades
                
                if(totalMarks < threshold){  // Check if total marks are below the threshold
                    System.out.println(firstName + " " + lastName + "(ID: " + studentID + ") has total marks: "+ totalMarks);
                }
                
                i++;
            }
            sc.close();
        } catch(FileNotFoundException e){ // Catch a potential file not found exception
            System.out.println("File not found"); //print error
        } finally{ //Finally block executes regardless of exceptions
            userInput.close();
        
        }
    }
     
    private static float parseGrade(String grade){ // Defines a private static method to parse grades
    if(grade.isEmpty()){  // Check if the grade string is empty
        System.out.println("Missing grade, defaulting to 0.0"); // Print a message for missing grades
        return 0.0f; // Return 0.0 as a default value for missing grades
        
        }   
     try{
        return Float.parseFloat(grade); // Attempt to parse the grade string as a float
    } catch(NumberFormatException e){
        System.out.println("Invalid grade format:"+ grade);//print error
        return 0.0f;
    
    }
  } 
} 

    
    
    
    
    







   