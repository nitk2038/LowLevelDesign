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
