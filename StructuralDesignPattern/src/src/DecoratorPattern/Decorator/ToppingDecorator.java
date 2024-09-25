package DecoratorPattern.Decorator;

import DecoratorPattern.BasePizza;

public abstract class ToppingDecorator extends BasePizza {
    public abstract int cost();
}
