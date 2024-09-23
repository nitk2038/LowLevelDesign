- Represents state in an application.
- Interface based with collection of concrete states
- State Pattern helps us separate what state we are in from where we are at in our application.
- Follows Open-Closed Principle (open for extension , closed for modification)
- Gets rid of nested if else structure
- eg: Vending Machine

UML Diagram
![](attachements/Pasted%20image%2020240923090055.png)

### Pitfalls
- Know your states
- Keep logic in states
- Know what exactly triggers state changes


| State             | Strategy              |
| ----------------- | --------------------- |
| Interface based   | Interface based       |
| Classes per state | Classes per algorithm |

## Code

Demo class
```
package State;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("State pattern");  
        Fan fan = new Fan();  
        System.out.println(fan);  
  
        fan.pullChain();  
        System.out.println(fan);  
  
        fan.pullChain();  
        System.out.println(fan);  
  
        fan.pullChain();  
        System.out.println(fan);  
  
        fan.pullChain();  
        System.out.println(fan);  
  
    }  
}
```

Fan class (Context)
```
package State;  
  
public class Fan {  
    State fanOffState;  
    State fanLowState;  
    State fanMedState;  
    State fanHighState;  
    State state;  
  
    public Fan() {  
        fanOffState = new FanOffState(this);  
        fanLowState = new FanLowState(this);  
        fanMedState = new FanMedState(this);  
        fanHighState = new FanHighState(this);  
        state = fanOffState;  
    }  
  
    public void pullChain() {  
        state.handleRequest();  
    }  
  
    public String toString() {  
        return state.toString();  
    }  
  
    public void setState(State state) {  
        this.state = state;  
    }  
  
    public State getLowState() {  
        return fanLowState;  
    }  
  
    public State getMedState() {  
        return fanMedState;  
    }  
  
    public State getHighState() {  
        return fanHighState;  
    }  
  
    public State getOffState() {  
        return fanOffState;  
    }  
}
```

State
```
package State;  
  
public abstract class State {  
    public void handleRequest() {  
        System.out.println("Invalid state");  
    }  
}
```

FanOffState
```
package State;  
  
public class FanOffState extends State {  
    private Fan fan;  
    public FanOffState(Fan fan) {  
        this.fan = fan;  
    }  
  
    public void handleRequest() {  
        System.out.println("Turning Fan on from off");  
        fan.setState(fan.getLowState());  
    }  
  
    public String toString (){  
        return "Fan is off";  
    }  
}
```

FanLow State
```
package State;  
  
public class FanLowState extends State {  
    private Fan fan;  
    public FanLowState(Fan fan) {  
        this.fan = fan;  
    }  
  
    public void handleRequest() {  
        System.out.println("Turning Fan low to Med");  
        fan.setState(fan.getMedState());  
    }  
  
    public String toString (){  
        return "Fan is Low speed";  
    }  
}
```

FanMediumState
```
package State;  
  
public class FanMedState extends State {  
    private Fan fan;  
    public FanMedState(Fan fan) {  
        this.fan = fan;  
    }  
  
    public void handleRequest() {  
        System.out.println("Turning Fan Medium to High");  
        fan.setState(fan.getHighState());  
    }  
  
    public String toString (){  
        return "Fan is Medium Speed";  
    }  
}
```

FanHigh State
```
package State;  
  
public class FanHighState extends State {  
    private Fan fan;  
    public FanHighState(Fan fan) {  
        this.fan = fan;  
    }  
  
    public void handleRequest() {  
        System.out.println("Turning Fan High to Off");  
        fan.setState(fan.getOffState());  
    }  
  
    public String toString (){  
        return "Fan is High Speed";  
    }  
}
```

Output
```
State pattern
Fan is off
Turning Fan on from off
Fan is Low speed
Turning Fan low to Med
Fan is Medium Speed
Turning Fan Medium to High
Fan is High Speed
Turning Fan High to Off
Fan is off

```