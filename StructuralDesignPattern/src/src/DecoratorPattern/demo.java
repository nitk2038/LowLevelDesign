package DecoratorPattern;

import DecoratorPattern.Decorator.ExtraCheese;
import DecoratorPattern.Decorator.ExtraOnion;

public class demo {
    public static void main(String[] args) {
        System.out.println("--- Decorator Design Pattern ---");
        System.out.println(" | VegDelight = rs 200 | Extra Onion = rs 20 | Extra Cheese = rs 10");
        BasePizza vegDelightPizza = new ExtraOnion(new ExtraCheese(new VegDelight()));
        System.out.println("VegDelight Pizza cost with extraCheese and ExtraOnion = rs." + vegDelightPizza.cost());
    }
}

