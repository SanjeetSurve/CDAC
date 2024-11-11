package Loans;

public record LoanFactory() {

    public static Loan createLoan(int loanType, double principal, float period) {
        return switch (loanType) {
            case 1 -> new PersonalLoan(principal, period);
            case 2 -> new HomeLoan(principal, period);
            default -> throw new IllegalArgumentException("Invalid Loan Type");
        };
    }

    public static void printLoanDetails(Loan loan) {
        System.out.println("\nLoan Amount: " + loan.getPrincipal());
        System.out.println("Loan Type: " + loan.getClass().getSimpleName());

        float rate = loan.getRate();
        double interestAmount = (loan.getPrincipal() * rate * loan.getPeriod()) / 100;
        System.out.printf("Interest Rate: %.2f%%, Interest Amount: %.2f%n", rate, interestAmount);

        double emi = loan.getEMI();
        System.out.printf("EMI (per month): %.2f%n", emi);

        if (loan instanceof Taxable taxable) {
            double tax = taxable.getTax();
            System.out.printf("Tax Applicable: %.2f%n", tax);
            System.out.println("----------------------------------------------------------------");
        }

        if (loan instanceof Discountable discountable) {
            double discount = discountable.getDiscount();
            System.out.printf("Discount Applicable: %.2f%n", discount);
            System.out.println("----------------------------------------------------------------");
        }
    }
}