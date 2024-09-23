package Strategy;

public class AmexValidationStrategy extends ValidationStrategy {

    @Override
    public boolean isValid(CreditCard creditCard) {
        if(creditCard.getNumber().startsWith("3")) return true;
        return false;
    }
}
