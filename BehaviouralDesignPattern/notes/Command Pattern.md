- Encapsulate request as an object, allowing for the separation of sender(invoker) and receiver.
- Commands can be parameterized, meaning you can create different commands with different parameters without changing the invoker(responsible for initiating command execution)
- Decouples invoker from receiver
- Often used for "undo" functionality by storing state
- eg: Switch that turn ON or turns OFF light

UML Diagram![](attachements/Pasted%20image%2020240922101040.png)

Similarity to Strategy Pattern

| Command                 | Strategy              |
| ----------------------- | --------------------- |
| Objects per command     | Objects per strategy  |
| Classes contains 'what' | Classes contain 'how' |
### Code

Demo Class
```
package CommandPattern;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Command Design Pattern");  
        Light light = new Light();  
        LightSwitch lightSwitch = new LightSwitch();  
        Command toggleCommand = new ToggleCommand(light);  
  
        lightSwitch.storeAndExecute(toggleCommand);  
        lightSwitch.storeAndExecute(toggleCommand);  
        lightSwitch.storeAndExecute(toggleCommand);  
    }  
}
```

Light Class(Receiver)
```
package CommandPattern;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Command Design Pattern");  
        Light light = new Light();  
        LightSwitch lightSwitch = new LightSwitch();  
        Command toggleCommand = new ToggleCommand(light);  
  
        lightSwitch.storeAndExecute(toggleCommand);  
        lightSwitch.storeAndExecute(toggleCommand);  
        lightSwitch.storeAndExecute(toggleCommand);  
    }  
}
```

LightSwitch Class(Invoker)
```
package CommandPattern;  
  
public class LightSwitch {  
    //invoker  
    public void storeAndExecute(Command command) {  
        command.execute();  
    }  
}
```

Command Interface
```
package CommandPattern;  
  
public interface Command {  
    public void execute();  
}
```

Concrete Toggle Command
```
public class ToggleCommand implements Command {  
    private final Light light;  
    public ToggleCommand(Light light) {  
        this.light = light;  
    }  
  
    @Override  
    public void execute() {  
        light.toggle();  
    }  
}
```

Output
```
Command Design Pattern
Light Switched On
Light Switched off
Light Switched On
```