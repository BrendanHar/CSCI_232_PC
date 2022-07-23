package ExampleCode.week1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class StudentDatabase {

    private Student[] database;

    public StudentDatabase() {
        database = new Student[0];
    }

    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i = 0; i < database.length; i++) {
            tempDatabase[i] = database[i];
        }

        tempDatabase[database.length] = newStudent;
        database = tempDatabase;
    }

    public void printDatabase() {
        for (int i = 0; i < database.length; i++) {
            Student student = database[i];
            System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
        }
        System.out.println();
    }
    
    public void copyStudent(int idNumber) {
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i = 0; i < database.length; i++) {
            tempDatabase[i] = database[i];
            if (database[i].getIdNumber() == idNumber) {
                //tempDatabase[database.length] = database[i];
                tempDatabase[database.length] = new Student(database[i].getName(), database[i].getIdNumber(), database[i].getGPA());
            }
        }

        database = tempDatabase;
    }
    
    public void updateGPA(int index, double newGPA) {
        database[index].changeGPA(newGPA);
    }
}
