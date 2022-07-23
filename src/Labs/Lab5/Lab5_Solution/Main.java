package Labs.Lab5.Lab5_Solution;

/**
 *
 * @author yaw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        
        database.addStudent("Joe Schmo", 1101, 3.2);
        database.addStudent("Katie Katerson", 31415926, 3.7);
        database.addStudent("Watson TheBassetHound", 12345, 2.4);
        database.addStudent("Joe Schmo", 99999, 4.0);
        database.addStudent("Lizzie", 88888, 3.7);
        
        database.printDatabase();
        
        database.countStudentsByName();
        database.printStudentsByGPA();
        
        database.findStudentByID(12345);
    }
    
}
