package Memento;

public class Originator {
    private int height;
    private int weight;
    public Originator(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Memento createMemento() {
        return new Memento(height, weight);
    }

    public void Undo(Memento memento) {
        System.out.println("Undo...");
        this.height = memento.getHeight();
        this.weight = memento.getWeight();
    }

    public void printInfo() {
        System.out.println("Weight: " + this.weight + " Height: " + this.height);
    }
}
