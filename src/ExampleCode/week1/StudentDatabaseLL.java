package ExampleCode.week1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class StudentDatabaseLL {
    
    public Node firstNode;
    public Node lastNode;
    
    public StudentDatabaseLL() {
        
    }
    
    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        Node newNode = new Node(newStudent);
        
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
    }
    
    public void printDatabase() {
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getIdNumber() + "), (gpa=" + currentNode.getStudent().getGPA() + ")");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
}
