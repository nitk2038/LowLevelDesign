- Defines a way to interpret and evaluate language grammar or expressions.
- eg: (2*3)+(4*5)

UML Diagram
![](attachements/Pasted%20image%2020240922111826.png)


- Context: The context may include variables, data structures, or other state information that the interpreter needs to access or modify while interpreting expressions
- Non-Terminal Expression: They recursively interpret their sub-expressions.

### Code 
```
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Interpreter Design Pattern");  
        Context context = new Context();  
        context.put("a", 5);  
        context.put("b", 3);  
  
        AbstractExpression expression = new MultiplyNonTerminalExpression(new TerminalExpression("a"), new TerminalExpression("b"));  
        System.out.println("Result of  a * b : " + expression.interpret(context));  
    }  
}
```

Context class
```
package Interpreter;  
  
import java.util.HashMap;  
import java.util.Map;  
  
public class Context {  
    Map<String, Integer>contextMap = new HashMap<>();  
    public void put(String key, int value) {  
        contextMap.put(key, value);  
    }  
    public int get(String key) {  
        return contextMap.get(key);  
    }  
}
```

AbstractExpression Interface
```
package Interpreter;  
  
public interface AbstractExpression {  
    int interpret(Context context);  
}
```

Terminal Expression
```
package Interpreter;  
  
public class TerminalExpression implements  AbstractExpression {  
    public String value;  
    public TerminalExpression(String value) {  
        this.value = value;  
    }  
    @Override  
    public int interpret(Context context) {  
        return context.get(value);  
    }  
}
```

MultiplyNonTerminal Expression
```
package Interpreter;  
  
public class MultiplyNonTerminalExpression implements AbstractExpression {  
    private AbstractExpression leftExpression;  
    private AbstractExpression rightExpression;  
  
    public MultiplyNonTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {  
        this.leftExpression = leftExpression;  
        this.rightExpression = rightExpression;  
    }  
  
    @Override  
    public int interpret(Context context) {  
        return leftExpression.interpret(context) * rightExpression.interpret(context);  
    }  
}
```

Output
```
Interpreter Design Pattern
Result of  a * b : 15

```