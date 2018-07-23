package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.equals("") || name.length() > 40){
            throw new IllegalArgumentException("invalid Name input");
        }
        this.name = name;
        if(age < 0 || age > 120){
            throw new IllegalArgumentException("invalid age input");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if(fromInteger < 0){
            throw new IllegalArgumentException("Number must be greater than or equal to 0");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0 || subsetSize > setSize){
            throw new IllegalArgumentException("Invalid inputs");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}

