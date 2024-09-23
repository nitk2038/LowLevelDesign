- Is used when you want to select the strategy/algorithm at runtime.
- Want to eliminate conditional statements
- Similar to state pattern

UML Diagram
![](attachements/Pasted%20image%2020240923101504.png)

### Pitfalls
- increased number of classes
- Client must be aware of different strategy

## Code

Demo Class
```
package Strategy;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Strategy pattern");  
        CreditCard visaCard = new CreditCard(new VisaValidationStrategy());  
        visaCard.setNumber("456789");  
        visaCard.setDate("23/08/2024");  
        visaCard.setCvv("003");  
  
        CreditCard visaCard2 = new CreditCard(new VisaValidationStrategy());  
        visaCard2.setNumber("951189");  
        visaCard2.setDate("23/08/2024");  
        visaCard2.setCvv("109");  
  
  
        CreditCard amexCard = new CreditCard(new AmexValidationStrategy());  
        amexCard.setNumber("330087");  
        amexCard.setDate("20/08/2024");  
        amexCard.setCvv("222");  
  
        System.out.println(visaCard);  
        visaCard.isValid();  
  
        System.out.println(visaCard2);  
        visaCard2.isValid();  
  
        System.out.println(amexCard);  
        amexCard.isValid();  
    }  
}
```

Validation Strategy (Abstract Class)
```
package Strategy;  
  
public abstract class ValidationStrategy {  
    public abstract boolean isValid(CreditCard creditCard);  
}
```

VisaValidationStrategy
```
package Strategy;  
  
public class VisaValidationStrategy extends ValidationStrategy {  
    @Override  
    public boolean isValid(CreditCard creditCard) {  
        if(creditCard.getNumber().startsWith("4")) return true;  
        return false;  
    }  
}
```


AmexValidationStrategy
```
package Strategy;  
  
public class AmexValidationStrategy extends ValidationStrategy {  
  
    @Override  
    public boolean isValid(CreditCard creditCard) {  
        if(creditCard.getNumber().startsWith("3")) return true;  
        return false;  
    }  
}
```

CreditCard (Context)
```
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
```

Output
```
Strategy pattern
[number: 456789] [date: 23/08/2024]  [cvv:003 ] 
Card is Valid
[number: 951189] [date: 23/08/2024]  [cvv:109 ] 
Invalid Card !!
[number: 330087] [date: 20/08/2024]  [cvv:222 ] 
Card is Valid
```