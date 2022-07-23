package ExampleCode.week1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDatabaseLL database = new StudentDatabaseLL();
        
        database.addStudent("Joe Schmo", 1101, 3.2);
        database.addStudent("Katie Katerson", 31415926, 3.7);
        database.addStudent("Watson TheBassetHound", 12345, 2.4);
        
        database.printDatabase();
        
        //database.copyStudent(1101);
        //database.printDatabase();
        
        //database.updateGPA(0, 1.0);
        //database.printDatabase();
    }  
}
