//Make Student implement the COmparable interface, so that the compareTo method would sort the students in alphabetic order.

public class Student implements Comparable<Student>{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Student student){
        return this.name.compareToIgnoreCase(student.getName());
    }

}
