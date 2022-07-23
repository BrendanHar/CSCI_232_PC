package Labs.Lab1;

public class Student {

    private String name;
    private double gpa;
    private int id;


    public Student(String x, int y, double z){
        this.name = x;
        this.id = y;
        this.gpa = z;

    }

    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setId(int id) {
        this.id = id;
    }

}
