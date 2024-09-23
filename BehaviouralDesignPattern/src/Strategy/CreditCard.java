package Strategy;

public class CreditCard {
    private String number;
    private String date;
    private String cvv;
    private ValidationStrategy validationStrategy;

    public CreditCard(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean isValid() {
        if(validationStrategy.isValid(this)) {
            System.out.println("Card is Valid");
            return true;
        }
        System.out.println("Invalid Card !!");
        return false;
    }

    public String toString() {
        return "[number: "+ this.number + "] [date: " + this.date + "]  [cvv:" + this.cvv + " ] ";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
