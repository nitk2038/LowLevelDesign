package Memento;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Memento pattern");
        CareTaker careTaker = new CareTaker();

        Originator originator = new Originator(180, 60);
        Memento snapshot1 = originator.createMemento();
        careTaker.addMemento(snapshot1);
        originator.printInfo();

        originator.setHeight(200);
        originator.setWeight(80);
        originator.printInfo();

        Memento snapshot2 = originator.createMemento();
        careTaker.addMemento(snapshot2);

        originator.setHeight(300);
        originator.setWeight(100);
        originator.printInfo();


        Memento snapshotUndo = careTaker.Undo();
        originator.Undo(snapshotUndo);
        originator.printInfo();

        Memento snapshotUndo2 = careTaker.Undo();
        originator.Undo(snapshotUndo2);
        originator.printInfo();
    }
}
