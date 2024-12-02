
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//import javafx.application.Preloader.StateChangeNotification;

class Student{
    private String lastName;
    private String firstName;
    private String studentID;
    private float A1;
    private float A2;
    private float A3;

    public float getTotalMarks(){
           return A1 + A2 + A3;
    }
    
    public Student(String lastName, String firstname, String studentID, float A1, float A2, float A3){
     this.lastName = lastName;
     this.firstName = firstName;
     this.studentID = studentID;
     this.A1 = A1;
     this.A2 = A2;
     this.A3 = A3;
    }
    @Override
    public String toString(){
        
        double totalMarks = getTotalMarks();        
        return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f", lastName, firstName, studentID, A1, A2, A3, totalMarks);                             
    
    }   
}
public class StudentMarks {
    public static void main(String[] args){
    //Scanner userInput = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    
    try{
       File f = new File ("prog5001_students_grade_2022.txt");
       Scanner sc = new Scanner(f);
       
       while (sc.hasNextLine()){
        String line = sc.nextLine();
        String[] parts = line.split(",");
        
        String lastName = parts[0];
        String firstName = parts[1];
        String studentID = parts[2];
        
        try{
        float A1 = Float.parseFloat(parts[3]);
        float A2 = Float.parseFloat(parts[4]);
        float A3 = Float.parseFloat(parts[5]);
        
        Student p = new Student(lastName, firstName, studentID, A1, A2, A3);
        students.add(p);
        
         // Print for debugging
                    System.out.println("Added student: " + p);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing grades for student: " + lastName + ", " + firstName + ", " + studentID);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found: " + e.getMessage());
        }
    
        students.sort((s1, s2) -> Float.compare(s2.getTotalMarks(), s1.getTotalMarks()));

        System.out.println("\nTop 5 Students with Highest Marks: ");
        for (int i = 0; i < Math.min(students.size(), 5); i++) {
            System.out.println(students.get(i).toString());
        }

        System.out.println("\nTop 5 Students with Lowest Marks: ");
        for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            System.out.println(students.get(i).toString());
        }
    }          
    
    }










   