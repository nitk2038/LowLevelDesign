package CreationalDesignPattern.AbstractFactoryPattern;

import CreationalDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;
import CreationalDesignPattern.AbstractFactoryPattern.Factory.MacFactory;
import CreationalDesignPattern.AbstractFactoryPattern.Factory.WindowsFactory;

public class Demo {
    public static void main(String args[]) {
        System.out.println("--- Abstract Factory Pattern ------ ");
        Application app = configureApplication();
        app.paint();
    }

    public static Application configureApplication() {
         Application app;
         GUIFactory factory;
         String osName = System.getProperty("os.name").toLowerCase();
         System.out.println(" Operating System Name " + osName);
         if(osName.contains("mac")) {
             factory = new MacFactory();
         } else {
            factory = new WindowsFactory();
         }
         app = new Application(factory);
         return app;
    }
}
