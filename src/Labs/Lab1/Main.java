package Labs.Lab1;

public class Main {
    public static void main(String[] args){
    StudentDatabase database = new StudentDatabase();

    database.addStudent("Joe Schmo", 1101, 3.2);
    database.addStudent("Katie Katerson", 31415926, 3.7);
    database.addStudent("Watson TheBassetHound", 12345, 2.4);

    database.printDatabase();

    database.copyStudent(1101);
    database.printDatabase();

    database.updateGPA(0, 1.0);
    database.printDatabase();

    // Lab 1 test Code
    System.out.println("---------------------------------------------");
    //Code to test Search by index method
    System.out.println("Student Search by Index:");
    System.out.println("Index of search: 3");
    database.findStudentByIndex(3);
    System.out.println();

    //Code to test search by name method
    System.out.println("Student search by name:");
    System.out.println("Student name: Katie Katerson");
    database.findStudentByName("Katie Katerson");
    System.out.println();

    //Code to test remove Student Method
    database.removeStudent(12345);
    System.out.println();
    System.out.println("New Database: ");
    database.printDatabase();

    //creating a linked list database to test the linked list methods
    System.out.println("---------------------------------------------");
    System.out.println("            Linked List Database");
    System.out.println("---------------------------------------------");
    StudentDatabaseLL database2 = new StudentDatabaseLL();

    database2.addStudent("Joe Schmo", 1101, 3.2);
    database2.addStudent("Katie Katerson", 31415926, 3.7);
    database2.addStudent("Watson TheBassetHound", 12345, 2.4);
    database2.addStudent("Joe Schmo", 1101, 1.0);

    //code testing the linked list search by index method
        //the array database method is better as it is constant time compared to the linked list's time of n
    database2.printDatabase();
    System.out.println();
    System.out.println("Student Search by Index:");
    System.out.println("Index of search: 1");
    database2.findStudentByIndex(1);
    System.out.println();

    //code testing the linked list search by name method
        //either linked list or an array method would work just as well as you have to search through the entire database to find students giving them both time n
    System.out.println("Student search by name:");
    System.out.println("Student name: Joe Schmo");
    database.findStudentByName("Joe Schmo");

    //code testing the linked list remove student method
        // the linked list remove student method is better than they array implementation as you don't have to create a whole new array of size -1 and copy in all values
    System.out.println();
    System.out.println("Student id of student being removed: 1101");
    database2.removeStudent(1101);
    System.out.println();
    System.out.println("         New Linked List Database");
    System.out.println("---------------------------------------------");
    database2.printDatabase();
    System.out.println("New First Node Linked List Database : ");
    database2.printFirst();
    System.out.println("New Last Node in Linked List Database: ");
    database2.printLast();
    System.out.println();
    System.out.println("See comments Linked list comments for running time use case discussion");
    }
}
