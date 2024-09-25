package CreationalDesignPattern.BuilderDesignPattern;

import CreationalDesignPattern.BuilderDesignPattern.Builders.Builder;
import CreationalDesignPattern.BuilderDesignPattern.Builders.Degree;
import CreationalDesignPattern.BuilderDesignPattern.Builders.Stream;

public class Director {
    public void createEngineerStudent(Builder builder) {
        builder.setAge(18);
        builder.setCuriosity(10);
        builder.setDegree(Degree.BTECH);
        builder.setStream(Stream.SCIENCE);
    }

    public void createMBAStudent(Builder builder) {
        builder.setAge(27);
        builder.setStream(Stream.COMMERCE);
        builder.setDegree(Degree.MBAFinance);
        builder.setCuriosity(25);
    }
}
