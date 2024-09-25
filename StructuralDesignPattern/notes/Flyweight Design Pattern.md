- This pattern helps to reduce the memory usage by sharing data among multiple objects.
- eg: Design word processor, Design Game
- Can be recognized by creation method that returns cached object instead of creating new.
- When to use this pattern ?
	- When memory is limited
	- When object shared data
		- Intrinsic Data: Shared among object and remain same once defined one value
		- Extrinsic Data: Changes based on client input and differs from one object to another.
	 - Creation of Object is expensive

- How to solve the issue ?
		- From object remove all extrinsic data & keep intrinsic data(this is Flyweight object eg: TreeType)
		- Extrinsic data can be passed to Flyweight class(Forest)
		- Once the flyweight object is created, it is cached and reused whenever required.

## Code

Demo Class
```
package StructuralDesignPattern.FlyweightPattern;  
  
import StructuralDesignPattern.FlyweightPattern.Forest.Forest;  
  
import java.awt.*;  
  
public class Demo {  
    static int CANVAS_SIZE = 500;  
    static int TREES_TO_DRAW = 1000000;  
    static int TREE_TYPES = 2;  
  
    public static void main(String[] args) {  
        System.out.println("--Flyweight Pattern---");  
        Forest forest = new Forest();  
        for(int i=0;i<Math.floor(TREES_TO_DRAW/TREE_TYPES); i++) {  
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "SummerOak", Color.green, "Oak tree stub");  
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Autumn Oak", Color.ORANGE, "Autumn tree stub");  
        }  
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);  
        forest.setVisible(true);  
  
        System.out.println(TREES_TO_DRAW + " trees drawn");  
        System.out.println("---------------------");  
        System.out.println("Memory usage:");  
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);  
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");  
        System.out.println("---------------------");  
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +  
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");  
    }  
  
    public static int random(int min, int max) {  
        return min + (int)(Math.random() * (max - min) + 1);  
    }  
}
```

Trees
Tree(Extrinsic data)
```
package StructuralDesignPattern.FlyweightPattern.Trees;  
  
import java.awt.*;  
  
public class Tree {  
    private int x;  
    private int y;  
    private TreeType treeType;  
  
    public Tree(int x, int y, TreeType treeType) {  
        this.x = x;  
        this.y = y;  
        this.treeType = treeType;  
    }  
  
    public void draw(Graphics g) {  
        treeType.draw(g, x, y);  
    }  
}
```

TreeFactory
```
package StructuralDesignPattern.FlyweightPattern.Trees;  
  
import java.awt.*;  
import java.util.HashMap;  
import java.util.Map;  
  
public class TreeFactory {  
    static Map<String, TreeType>treeTypes = new HashMap<>();  
    public static TreeType getTreeType(String name, Color color, String otherTreeData) {  
        TreeType result = treeTypes.get(name);  
        if(result == null) {  
            result = new TreeType(name, color, otherTreeData);  
            treeTypes.put(name, result);  
        }  
        return result;  
    }  
}
```

TreeType (Flyweight Object) (intrinsic data)
```
package StructuralDesignPattern.FlyweightPattern.Trees;  
  
import java.awt.*;  
  
public class TreeType {  
    private String name;  
    private Color color;  
    private String otherTreeData;  
  
    public TreeType(String name, Color color, String otherTreeData) {  
        this.name = name;  
        this.color = color;  
        this.otherTreeData = otherTreeData;  
    }  
  
    public void draw(Graphics g, int x, int y) {  
        g.setColor(Color.black);  
        g.fillRect(x-1, y, 3, 5);  
        g.setColor(color);  
        g.fillOval(x-5, y-10, 10, 10);  
    }  
}
```


Forest(Flyweight class)
```
package StructuralDesignPattern.FlyweightPattern.Forest;  
  
import StructuralDesignPattern.FlyweightPattern.Trees.Tree;  
import StructuralDesignPattern.FlyweightPattern.Trees.TreeFactory;  
import StructuralDesignPattern.FlyweightPattern.Trees.TreeType;  
  
import javax.swing.*;  
import java.awt.*;  
import java.util.ArrayList;  
import java.util.List;  
  
public class Forest extends JFrame {  
    private List<Tree>trees = new ArrayList<>();  
  
    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {  
        TreeType treeType = TreeFactory.getTreeType(name, color, otherTreeData);  
        Tree tree = new Tree(x, y, treeType);  
        trees.add(tree);  
    }  
  
    public void paint(Graphics g) {  
        for(Tree tree: trees) {  
            tree.draw(g);  
        }  
    }  
}
```

Output
```
--Flyweight Pattern---
1000000 trees drawn
---------------------
Memory usage:
Tree size (8 bytes) * 1000000
+ TreeTypes size (~30 bytes) * 2
---------------------
Total: 7MB (instead of 36MB)
```