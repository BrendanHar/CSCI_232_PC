package Labs.Lab5.Lab5_assigned_code;

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
        database.addStudent("Joe Schmo", 1102, 3.4);
        database.addStudent("Katie Katerson", 31415926, 3.7);
        database.addStudent("Watson TheBassetHound", 12345, 2.4);
        database.countStudentsByName();
        System.out.println();
        if(!database.findStudentByID(1102)){
            System.out.println("Not student with that id.");
        }
        System.out.println();
        database.printStudentsByGPA();
    }
    
}
