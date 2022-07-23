package Labs.Lab1;

public class Node {

    private Node next;
    private Student student;

    public Node(Student student){
        this.student = student;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Student getStudent() {
        return student;
    }
}
