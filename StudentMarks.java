
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File; //Import the File class
import java.io.FileNotFoundException; //Import this class to handle errors
import java.util.Scanner; //Import the Scanner class to read text files

class Student {
    // instance variables - replace the example below with your own
    private String lastName;
    private String firstName;
    private String studentID;
    private float A1;
    private float A2;
    private float A3;

    // /**
     // * Constructor for objects of class Student
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

  public Student(){
    }  
    
    public double getNotaFinal(){
    return (A1 + A2 + A3) / 3.;
    }
    
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
    public float getA1(){
        return A1;
    }
    
    public float getA2(){
        return A2;
    }

    public float getA3(){
        return A3;
    }
     
    
  public boolean setLastName(String lastName){
    
    if ((lastName.length() > 2) && (lastName.length() < 30)){
             this.lastName = lastName;
        } else{
            return false;
        }
        return true;
    }

    public boolean setFirstName(String firstName){
    
        if ((firstName.length() > 2) && (firstName.length() < 20)){
            this.firstName = firstName;
        } else{
            return false;
        }
        return true;
    }
    
    public boolean setStudentID(String studentID){
    
        if ((studentID.length() > 2) && (studentID.length() < 10)){
            this.studentID = studentID;
        } else{
            return false;
        }
        return true;
    }
    
    
    public boolean seta1(float A1){
    
        if( (A1>0) && (A1<30)){
            this.A1 = A1;
        }else {
            return false;
        }
        return true;
    }
    
    public boolean seta2(float A2){
    
        if( (A2>0) && (A2<30)){
            this.A2 = A2;
        }else {
            return false;
        }
        return true;
    }
    
    public boolean seta3(float A3){
    
        if( (A3>0) && (A3<30)){
            this.A3 = A3;
        }else {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        double notaFinal =getNotaFinal();
        //float notaFinal = getNotaFinal();
        return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f", lastName, firstName, studentID, A1, A2, A3, notaFinal);                             
    
    }
}
   // the main method
    public class StudentMarks{
   public static void main (String[] args){
       
       Scanner userInput = new Scanner(System.in);
       System.out.print("Enter the minimun total mark threshold: ");
       float threshold = userInput.nextFloat();
       
       
       
       try{
           File f = new File ("prog5001_students_grade_2022.txt");
           Scanner sc = new Scanner(f);
           
           int i=0;
           while(sc.hasNextLine()){
               String s = sc.nextLine();
               String lastName = "";
               String firstName = "";
               String studentID = "";
               if (i>0){
               
                String[] details = s.split(",");
                lastName = details[0];
                firstName = details[1];
                studentID = details[2];
                  
                  float A1 = 0, A2 = 0, A3 = 0;
                  try{
                   A1 = Float.parseFloat(details[3]);
                   for(int j=4; j<details.length; j++){
                    //if(j==5){
                        //A2= details.length >5 ? Float.parseFloat(details[5]) : 0.0f;
                        A2 = Float.parseFloat(details[j].isEmpty() ? "0.0f": details[j]);
                     if (j + 1 < details.length){
                    
                         A3 = Float.parseFloat(details[j+1].isEmpty()? "0.0f": details[j]);
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











   