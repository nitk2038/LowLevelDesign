package CreationalDesignPattern.BuilderDesignPattern;

import CreationalDesignPattern.BuilderDesignPattern.Builders.Builder;
import CreationalDesignPattern.BuilderDesignPattern.Builders.StudentBuilder;
import CreationalDesignPattern.BuilderDesignPattern.Student.Student;

public class Demo {
    public static void main(String args[]) {
        System.out.println(" --- Builder Design Pattern --- ");
        Director director = new Director();
        StudentBuilder studentBuilder = new StudentBuilder();
        director.createEngineerStudent(studentBuilder);

        director.createMBAStudent(studentBuilder);
        Student mbaGrad = studentBuilder.build();
        mbaGrad.PrintDetails();

        Student Engineer = studentBuilder.build();
        Engineer.PrintDetails();
    }
}
