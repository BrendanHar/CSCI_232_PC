package Labs.Lab5.Lab5_Solution;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author yaw
 */
public class StudentDatabase {

    private HashMap<String, HashSet<Student>> database;

    public StudentDatabase() {
        database = new HashMap<>();
    }

    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        if (!database.containsKey(name)) {
            database.put(name, new HashSet<>());
        }
        database.get(name).add(newStudent);
    }

    public void printDatabase() {
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
                System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
            }
        }
        System.out.println();
    }

    // TODO
    public void countStudentsByName() {
        for (String name : database.keySet()) {
            System.out.println(name + ": " + database.get(name).size());
        }
        System.out.println();
    }

    // TODO
    public void findStudentByID(int id) {
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
                if (student.getIdNumber() == id) {
                    System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                }
            }
        }
        System.out.println();
    }

    // TODO
    public void printStudentsByGPA() {
        HashMap<Double, HashSet<Student>> studentsByGPA = new HashMap<>();
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
                if (!studentsByGPA.containsKey(student.getGPA())) {
                    studentsByGPA.put(student.getGPA(), new HashSet<>());
                }
                studentsByGPA.get(student.getGPA()).add(student);
            }
        }
        
        for (double gpa : studentsByGPA.keySet()) {
            System.out.println(gpa + ":");
            for (Student student : studentsByGPA.get(gpa)) {
                System.out.println("  " + student.getName() + ", " + student.getIdNumber());
            }
        }
        System.out.println();
    }

    public void removeStudent(String name) {
        database.remove(name);
    }
}
