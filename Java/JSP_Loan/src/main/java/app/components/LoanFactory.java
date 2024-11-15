package app.components;

public record LoanFactory() {

    public static Loan createLoan(int loanType, double principal, float period) {
        // ithe aapan Basically check kartoy ki aapla loan kontya type cha aahe by using switch case
        return switch (loanType) {
            case 1 -> new PersonalLoan(principal, period);
            case 2 -> new HomeLoan(principal, period);

            // jar kahi pn chuki cha data dila tar toh error takel
            default -> throw new IllegalArgumentException("Invalid Loan Type");
        };
    }

    public static void printLoanDetails(Loan loan) {
        // ith aapn Loan <- ha apla class ahe aani loan <- ha obj aahe 
        System.out.println("\nLoan Amount: " + loan.getPrincipal());

        // Runtime madhe ithe basically decide hoil loan type ani loan.getClass() ha tya class la call karel ani .getSimpleName() ha tyacha nav print karel
        System.out.println("Loan Type: " + loan.getClass().getSimpleName());

        float rate = loan.getRate();
        double interestAmount = (loan.getPrincipal() * rate * loan.getPeriod()) / 100;
        System.out.printf("Interest Rate: %.2f%%, Interest Amount: %.2f%n", rate, interestAmount);

        double emi = loan.getEMI();
        System.out.printf("EMI (per month): %.2f%n", emi);

        // ithe basically apan check karoty ki ki Taxable ha instance manje method aahe ka tya class madhe jasa aata aplya personal loan la aahe 
        if (loan instanceof Taxable taxable) {
            double tax = taxable.getTax();
            System.out.printf("Tax Applicable: %.2f%n", tax);
            System.out.println("----------------------------------------------------------------");
        }

        // ithe pan same check kartoy ki Discount ha instance ahe ki nahi
        if (loan instanceof Discountable discountable) {
            double discount = discountable.getDiscount();
            System.out.printf("Discount Applicable: %.2f%n", discount);
            System.out.println("----------------------------------------------------------------");
        }
    }
}