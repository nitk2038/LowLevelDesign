package CreationalDesignPattern.BuilderDesignPattern.Builders;

public interface Builder {
    void setDegree(Degree degree);
    void setAge(Integer age);
    void setStream(Stream stream);
    void setCuriosity(Integer curiosityLevel);
}
