
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

public class Readfile{
    public static void main(String[] args){
    try{
        File myObj = new File("prog5001_students_grade_2022");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()){
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
       } catch (FileNotFoundException e){
        System.out.println("An error ocurred.");
        e.printStackTrace();
        }
        
        }
    
    }


class Student
{
    // instance variables - replace the example below with your own
    private String LastName;
    private String FirstName;
    private double StudentID;
    private double A1;
    private double A2;
    private double A3;

    /**
     * Constructor for objects of class Student
     */
    public Student(String LastName, String FirstName, double StudentID, double A1, double A2, double A3)
    {
        // initialise instance variables
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.StudentID = StudentID;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
    }

    /**
     * methods to access the properties
     */
    public double getStudentID()
    {
        return StudentID;
    }
    
    public double getA1(){
        return A1;
    }
    
    public double getA2(){
        return A2;
    }

    public double getA3(){
        return A3;
    }

    /**
     * methods to manpulate the properties
     */
    public boolean setlastName(String LastName){
    
        if ((LastName.length() > 2) && (LastName.length() < 30)){
            this.LastName = LastName;
        } else{
            return false;
        }
        return true;
    }

    public boolean setfirstName(String FirstName){
    
        if ((FirstName.length() > 2) && (FirstName.length() < 16)){
            this.FirstName = FirstName;
        } else{
            return false;
        }
        return true;
    }
    
    public boolean setass1(double A1){
    
        if( A1>0 && A1<30){
            this.A1 = A1;
        }else {
            return false;
        }
        return true;
    }
    
    public boolean setass2(double A2){
    
        if( A2>0 && A2<30){
            this.A2 = A2;
        }else {
            return false;
        }
        return true;
    }
    
    public boolean setass3(double A3){
    
        if( A3>0 && A3<30){
            this.A3 = A3;
        }else {
            return false;
        }
        return true;
    }
    
    /**
     * method to export the Student data as a string
     */
    
} 

