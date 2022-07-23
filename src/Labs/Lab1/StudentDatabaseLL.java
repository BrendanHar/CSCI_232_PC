package Labs.Lab1;

public class StudentDatabaseLL {

    public Node first;
    public Node last;

    public StudentDatabaseLL(){

    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void printFirst(){
        System.out.println(first.getStudent().getName() + ": (ID=" + first.getStudent().getId() +"), (GPA=" + first.getStudent().getGpa() + ")");
    }

    public void printLast(){
        System.out.println(last.getStudent().getName() + ": (ID=" + last.getStudent().getId() +"), (GPA=" + last.getStudent().getGpa() + ")");
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void addStudent(String name, int id, double gpa){
        Student newStudent = new Student(name, id , gpa );
        Node newNode = new Node(newStudent);
        if (first == null){
            first = newNode;
            last = newNode;
        }
        else{
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void printDatabase(){
        Node currentNode = first;
        while (currentNode != null){
            System.out.println(currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void findStudentByIndex(int index){
        Node currentNode = first;
        for (int i =0; i <index; i++){
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
    }

    public void findStudentByName(String name){
        Node currentNode = first;
        while (currentNode!= null){
            if (currentNode.getStudent().getName() == name){
                System.out.println(currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
                currentNode = currentNode.getNext();
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
    }

    public void removeStudent(int id){
//        boolean check = false;
        Node currentNode = first;
        Node previousNode = first;
        while (currentNode != null){
            if (currentNode == first){
                // exception to set new first in the linked list
                if (currentNode.getStudent().getId() == id){
                    //System.out.println("Student who is being removed: " + currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
                    first = first.getNext();
                    currentNode.getNext();
//                    check = true;
                }
                // updating only the current node to leave the previous node 1 behind the current node
                else {
                    currentNode = currentNode.getNext();
                }
            }
            //exception to set new last if current last is being removed
            else if (currentNode == last){
                if (currentNode.getStudent().getId() == id){
                    System.out.println("Student who is being removed: " + currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
                    last = previousNode;
                    previousNode.setNext(null);
                    currentNode = currentNode.getNext();
                }
            }
            //
            else{
                if (currentNode.getStudent().getId() == id){
                    System.out.println("Student who is being removed: " + currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getId() +"), (GPA=" + currentNode.getStudent().getGpa() + ")");
                    previousNode.setNext(currentNode.getNext());
                    currentNode = currentNode.getNext();
                    previousNode = previousNode.getNext();

//                    check = true;
                }
                else{
                    currentNode = currentNode.getNext();
                    previousNode = previousNode.getNext();
                }
            }
        }
    }

}
