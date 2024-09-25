- Let's you provide a substitute / placeholder for another object.
- A proxy controls access to original object , allowing you to perform something  either before/after the request gets through the original object.
- eg: Pre-Post Log Processing, Blacklisting IPs, Caching

UML Diagram


## Code

Demo Class
```
package StructuralDesignPattern.ProxyPattern;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Proxy Pattern");  
        Image proxyImage = new ProxyImage("example.jpeg");  
        proxyImage.display();  
        proxyImage.display();  
    }  
}
```

Image(interface)
```
package StructuralDesignPattern.ProxyPattern;  
  
public interface Image {  
    void display();  
}
```

RealImage
```
package StructuralDesignPattern.ProxyPattern;  
  
public class RealImage implements Image {  
    private String imageName;  
    public RealImage(String imageName) {  
        this.imageName = imageName;  
        loadImageFromDisk();  
    }  
  
    public void loadImageFromDisk() {  
        System.out.println("Loading image from Disk .....");  
    }  
  
    @Override  
    public void display() {  
        System.out.println("Displaying Image: "+ imageName);  
    }  
}
```

ProxyImage
```
package StructuralDesignPattern.ProxyPattern;  
  
public class ProxyImage implements Image {  
    private RealImage realImage;  
    private String imageName;  
    public ProxyImage(String imageName) {  
        this.imageName = imageName;  
    }  
    @Override  
    public void display() {  
        if(realImage == null) {  
            realImage = new RealImage(imageName);  
        }  
        realImage.display();  
    }  
}
```

Output
```
Proxy Pattern
Loading image from Disk .....
Displaying Image: example.jpeg
Displaying Image: example.jpeg

```

