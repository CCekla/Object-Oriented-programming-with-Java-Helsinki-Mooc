
package people;

public class Person {
    private String name;
    private String adress;
    
    public Person(String name, String adress){
        this.name = name;
        this.adress = adress;
    }
    
    @Override
    public String toString(){
        return this.name + "\n" +
        "  " + this.adress;
    }
}



package people;

public class Student extends Person{
    private int credits;
    
    public Student(String name, String adress) {
        super(name, adress);
        this.credits = 0;
    }
    
    public int credits(){
        return this.credits;
    }
    
    public void study(){
        this.credits++;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" 
                + "  credits " + this.credits;
    }
}



package people;

public class Teacher extends Person{
    private int salary;
    
    public Teacher(String name, String adress, int salary){
        super(name, adress);
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n"
                + "  salary "+ this.salary+ " euros/month";
    }
    
}

