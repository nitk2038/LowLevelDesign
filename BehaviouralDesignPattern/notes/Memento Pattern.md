- Externalize an Object state to usually provide the undo/rollback functionality.
- eg: Design Traffic Light System

UML Diagram
![](attachements/Pasted%20image%2020240922155207.png)

Originator : Is whose copy we want to create or return to state.
CareTaker: Manages storage and retrieval of Memento Object

#### Pitfalls
- Memory Leak
- Can get heavy with history

| Memento            | Command             |
| ------------------ | ------------------- |
| Independent State  | Independent Request |
| History is tracked | History not tracked |


## Code

Demo Class
```
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
```


Originator Class
```
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
```

Memento Class
```
package Memento;  
  
public class Memento {  
    private int height;  
    private int weight;  
    public Memento(int height, int weight) {  
        this.height = height;  
        this.weight = weight;  
    }  
  
    public int getHeight() {  
        return height;  
    }  
  
    public int getWeight() {  
        return weight;  
    }  
}
```

CareTaker Class
```
package Memento;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class CareTaker {  
    List<Memento>history = new ArrayList<>();  
  
    public void addMemento(Memento memento) {  
        System.out.println("Saving snapshot...");  
        history.add(memento);  
    }  
  
    public Memento Undo() {  
        if(!history.isEmpty()) {  
            int lastMementoIndex = history.size()-1;  
            Memento snapshot = history.get(lastMementoIndex);  
            history.remove(lastMementoIndex);  
            return snapshot;  
        }  
        return null;  
    }  
  
}
```

Output
```
Memento pattern
Saving snapshot...
Weight: 60 Height: 180
Weight: 80 Height: 200
Saving snapshot...
Weight: 100 Height: 300
Undo...
Weight: 80 Height: 200
Undo...
Weight: 60 Height: 180
Undo...
```