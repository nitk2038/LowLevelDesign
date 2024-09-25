- Used when we have to create only 1 instance of a class.
- We make the constructor of the class Private.
- 4 ways to achieve this
1) Eager (object created at the time of class creation)
2) Lazy (Code below)
3) Synchronized Method (Synchronized public static Singletion getInstance())
4) Double Locking

## Code

Demo Class
```
package CreationalDesignPattern.SingletonPattern;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("--- Singleton Pattern ----");  
        Singleton s1 = Singleton.getInstance("foo");  
        Singleton s2 = Singleton.getInstance("boo");  
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +  
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +  
                "RESULT:" + "\n");  
        System.out.println(s1.value);  
        System.out.println(s2.value);  
    }  
}
```

Singleton Class
```
package CreationalDesignPattern.SingletonPattern;  
  
public final class Singleton {  
    private static Singleton instance;  
    public String value;  
  
    private Singleton(String value) {  
        // The following code emulates slow initialization.  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException ex) {  
            ex.printStackTrace();  
        }  
        this.value = value;  
    }  
  
    public static Singleton getInstance(String value) {  
        if (instance == null) {  
            instance = new Singleton(value);  
        }  
        return instance;  
    }  
}
```

Output
```
--- Singleton Pattern ----
If you see the same value, then singleton was reused (yay!)
If you see different values, then 2 singletons were created (booo!!)

RESULT:

foo
foo
```
