package CreationalDesignPattern.BuilderDesignPattern.Student;

import CreationalDesignPattern.BuilderDesignPattern.Builders.Degree;
import CreationalDesignPattern.BuilderDesignPattern.Builders.Stream;

public class Student {
    private Integer age;
    private Degree courseDegree;
    private Integer curiosity;
    private Stream stream;

    public Student(Integer age, Degree courseDegree, Integer curiosity, Stream stream) {
        this.age = age;
        this.courseDegree = courseDegree;
        this.curiosity = curiosity;
        this.stream = stream;
    }

    public void PrintDetails() {
        System.out.println("--- Student Details ---");
        System.out.println("Student has age of "+ age + " and completed courseDegree "+courseDegree+" , curiosityLevel is "+ curiosity+" and took stream "+ stream);
    }
}
