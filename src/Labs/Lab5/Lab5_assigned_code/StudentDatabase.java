package Labs.Lab5.Lab5_assigned_code;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

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

    public void removeStudent(String name) {
        database.remove(name);
    }

    public void countStudentsByName() {
        // TODO

//        for (int i =0; i < database.size(); i++){
            for (String name : database.keySet()){
                int count = 0;
                for (Student student : database.get(name)){
                    count++;
                    System.out.println("Number of students with name " + student.getName() + ": " +  count);
//                }
            }
        }
    }

    public boolean findStudentByID(int id) {
        // TODO
        for (String name : database.keySet()){
            for (Student student : database.get(name)){
                if(student.getIdNumber() == id){
                    System.out.println("Student with id: "+ id + " is " + student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public void printStudentsByGPA() {
        // TODO
        ArrayList<Student> arr = new ArrayList<>();
        for (String name : database.keySet()){
            for (Student student : database.get(name)){
                arr.add(student);
            }
        }
        int maxValue = 0;

        for (Student student: arr){
            for(Student student1 : arr){
                if (maxValue <= student.getGPA()){
                maxValue = (int) student.getGPA();
                arr.set(1, student);
                }
            }
        }
        for (Student student: arr){
            System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
        }
    }
}
