package Labs.Lab1;

public class StudentDatabase {

    private Student[] database;

    public StudentDatabase(){
        database = new Student[0];
    }

    public void addStudent(String name, int id, double gpa){
        Student newStudent = new Student(name, id , gpa );
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i = 0; i < database.length; i++){
             tempDatabase[i] = database[i];
        }
        tempDatabase[database.length] = newStudent;
        database = tempDatabase;
    }

    public void printDatabase(){
        for (int i = 0; i < database.length; i++) {
            Student student = database[i];
            if (database[i] != null) {
                System.out.println(student.getName() + ": (ID=" + student.getId() + "), (GPA=" + student.getGpa() + ")");
            }
        }
        System.out.println();
    }

    public void copyStudent(int id){
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i=0; i < database.length; i++){
            tempDatabase[i] = database[i];
            if (database[i].getId() == id){
                tempDatabase[database.length] = new Student(database[i].getName(),database[i].getId(),database[i].getGpa());
            }
        }
        database = tempDatabase;
    }

    public void updateGPA(int index, double newGPA){
        database[index].setGpa(newGPA);
    }

    public void findStudentByIndex(int index){
        System.out.println(database[index].getName() + ": (ID=" + database[index].getId() +"), (GPA=" + database[index].getGpa() + ")");
    }

    public void findStudentByName(String name){
        for(int i=0; i<database.length; i++){
//            System.out.println(database[i].getName());
            if (database[i].getName() == name){
                System.out.println(database[i].getName() + ": (ID=" + database[i].getId() +"), (GPA=" + database[i].getGpa() + ")");
            }
        }
    }

    public void removeStudent(int id){
        Student[] tempDatabase = new Student[database.length - 1];
        int index = 0;
        for (int i=0; i < database.length; i++){
            if (database[i].getId() == id){
                System.out.println("Student who is being removed: " + database[i].getName() + ": (ID=" + database[i].getId() +"), (GPA=" + database[i].getGpa() + ")");
            }
            else {
                tempDatabase[index] = database[i];
                index++;
            }
        }
        database = tempDatabase;
    }

}
