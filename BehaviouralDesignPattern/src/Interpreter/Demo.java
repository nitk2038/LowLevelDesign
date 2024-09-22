package Interpreter;

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
