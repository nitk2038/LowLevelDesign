package CreationalDesignPattern.BuilderDesignPattern.Builders;

import CreationalDesignPattern.BuilderDesignPattern.Student.Student;

public class StudentBuilder implements Builder {
    private Integer age;
    private Degree courseDegree;
    private Integer curiosity;
    private Stream stream;

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDegree(Degree degree) {
        this.courseDegree = degree;
    }

    public void setCuriosity(Integer curiosity) {
        this.curiosity = curiosity;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Integer getAge() {
        return age;
    }

    public Degree getCourseDegree(){
        return courseDegree;
    }

    public Student build() {
        return new Student(age, courseDegree, curiosity, stream);
    }
}
