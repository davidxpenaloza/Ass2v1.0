
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

//Define the Student class to encapsulate the details and academic performance of an individual student.
class Student {
    // Instance variables for the purpose of storing student information."
    private String lastName;
    private String firstName;
    private String studentID;
    private float A1;
    private float A2;
    private float A3;

    // /**
     // * Constructor to instantiate a Student object with the specified details.
     // */
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
   // Defin the StudentMarks class containing the main method
    public class StudentMarks{
            
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
           while(sc.hasNextLine()){
               //Initialize variables to store student information
               String s = sc.nextLine();
               String lastName = "";
               String firstName = "";
               String studentID = "";
               //Process lines only after the header
               if (i>0){
               
                String[] details = s.split(",");
                //Extract student information from the split details
                lastName = details[0];
                firstName = details[1];
                studentID = details[2];
                // Initialize variables for the purpose of storing student grades.
                  float A1 = 0, A2 = 0, A3 = 0;
                  //Utilize a try-catch block to effectively manage any potential NumberFormatException that may occur during the parsing of grades.
                  try{
                   A1 = Float.parseFloat(details[3]); //Parse the first grade (A1) from the details array
                   for(int j=4; j<details.length; j++){
                        A2 = Float.parseFloat(details[j].isEmpty() ? "0.0f": details[j]); // Parse the second grade (A2)
                     if (j + 1 < details.length){
                    
                         A3 = Float.parseFloat(details[j+1].isEmpty()? "0.0f": details[j]); // Parse the third grade (A3)
                        }
                    }
                    
                    
                }catch (NumberFormatException e){
                     System.err.println("Error parsing grades for "+ lastName + "," + firstName + ":" + e.getMessage());    
                    }
                   Student p = new Student(lastName, firstName, studentID, A1, A2, A3);
                   if(p.getNotaFinal()<threshold){
                       System.out.println(p.toString());
                    }
                }

                i++;
        
            }
    }catch(FileNotFoundException e){
            e.printStackTrace();
        }
       
        userInput.close();
  }
}











   