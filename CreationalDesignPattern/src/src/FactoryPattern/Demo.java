package CreationalDesignPattern.FactoryPattern;

import CreationalDesignPattern.FactoryPattern.Factory.Dialog;
import CreationalDesignPattern.FactoryPattern.Factory.HtmlDialog;
import CreationalDesignPattern.FactoryPattern.Factory.WindowsDialog;

public class Demo {
    private static Dialog dialog; //has main method is Static, & we know static method cannot access non static field/method
    public static void main(String args[]) {
        System.out.println(" ------ Factory Pattern ------");
        configure();
        runBuisnessLogic();
    }

    public static void configure() {
        System.out.println("Printing System Property: "+ System.getProperty("os.name"));
        if(System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    public static void runBuisnessLogic() {
        dialog.renderWindow();
    }
}
