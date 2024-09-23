package Strategy;

public class VisaValidationStrategy extends ValidationStrategy {
    @Override
    public boolean isValid(CreditCard creditCard) {
        if(creditCard.getNumber().startsWith("4")) return true;
        return false;
    }
}
