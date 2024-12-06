
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
import java.io.FileReader;

//Stores of each variable, represents the Student Class
class Student{
    String lastName;
    String firstName;
    String studentID;
    List<Double> marks; //Represents a list of the student's marks in various assignments
    double average; //Calculate average of Student's marks
    
    public Student(String lastName, String firstName, String studentID, List<Double> marks){
      this.lastName = lastName;
      this.firstName = firstName;
      this.studentID = studentID;
      this.marks = marks;
      calculateAverage();
    }
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
    public String toString(){ //Constructs a string representation of the Student Object that have: lastName, firstName, marks
        return lastName + ", " + firstName + "(" + studentID + ") - Marks: " +marks+ " - Average: " + String.format("%.2f", average);
    }
    
}
    
public class StudentOrder{

    public static void main(String[] args){
        String filename = "prog5001_students_grade_2022.txt"; //Specify the filename to read
        List<Student> students = readStudentData(filename); //Reading the file
        //Checking if the list is empty
        if(students.isEmpty()){
            System.out.println("No valid student data found");//If is empty, print a message and exit
            return;
        }
        //Organize the students based on their average marks in descending order.
        Collections.sort(students,Comparator.comparingDouble(student -> student.average));
        
        System.out.println("Five Students with hight Average Marks:");//Print the five students with hight marks
        for(int i=0; i < Math.min(5, students.size()); i++){
            System.out.println(students.get(students.size() -1 - i));
        
        }
    }    
    
    private static List<Student> readStudentData(String filename){
        List<Student> studentList = new ArrayList<>(); //An empty list is created to store the students
        //Read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            br.readLine();
            br.readLine();
            //Read each line until the end of the file
            while((line = br.readLine()) != null){ 
                //Eliminate unnecessary line content and exclude any blank or comment lines
                line = line.trim();
                //Divide the line into sections according to the placement of commas
                if(line.isEmpty() || line.startsWith("#")){
                    //Omit lines that contain inadequate data
                   continue;
                }
                
                String[] parts = line.split(",");
                if(parts.length < 4){
                   continue;
                }
                //Extract student information from the specified sections
                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                String studentID = parts[2].trim();
                List<Double> marks = new ArrayList<>();
                //Extract marks from the remaining sections
                for (int i = 3; i < parts.length; i++){
                    if(parts[i].trim().isEmpty()){
                        marks.add(0.0); // Treat empty marks as 0.0
                    } else{
                        //Interpret the mark as a double data type
                        marks.add(Double.parseDouble(parts[i].trim()));
                    }
                }
                //Instantiate a new Student object and incorporate it into the list
                studentList.add(new Student(lastName, firstName, studentID, marks));
             }
          
    } catch (IOException e) {
         System.err.println("Error reading the file: " + e.getMessage());//Display an error message in the event that an exception occurs during the file reading process
    }
    //return the list of students    
    return studentList;
  }
}











   