import Loans.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Loan[] loans = new Loan[10];
        int loanCount = 0;

        while (true) {
            System.out.println("Enter details for Loan " + (loanCount++) + ":");

            System.out.print("Enter Principal Amount: ");
            double principal = sc.nextDouble();

            System.out.print("Enter Loan Period (years): ");
            int period = sc.nextInt();

            System.out.print("Enter Loan Type (1 for PersonalLoan, \n2 for HomeLoan): ");
            int loanType = sc.nextInt();

            try {
                loans[loanCount] = LoanFactory.createLoan(loanType, principal, period);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid loan type selected. Defaulting to PersonalLoan.");
                loans[loanCount] = new PersonalLoan(principal, period);
            }
            loanCount++;

            System.out.print("Do you want to add another loan? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        double totalEmi = 0, totalTax = 0, totalDiscount = 0;

        for (int i = 0; i < loanCount; i++) {
            Loan loan = loans[i];
            LoanFactory.printLoanDetails(loan);

            totalEmi += loan.getEMI();
            if (loan instanceof Taxable taxable) totalTax += taxable.getTax();
            if (loan instanceof Discountable discountable) totalDiscount += discountable.getDiscount();
        }

        System.out.printf("Total EMI for all loans: %.2f%n", totalEmi);
        System.out.printf("Total Tax for all Personal Loans: %.2f%n", totalTax);
        System.out.printf("Total Discount for all Home Loans: %.2f%n", totalDiscount);

        sc.close();
    }
}