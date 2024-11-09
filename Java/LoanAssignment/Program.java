import Loans.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Loan[] loans = new Loan[10];
        int loanCount = 0;


        while (true) {
            System.out.println("Enter details for Loan " + (loanCount + 1) + ":");

            System.out.print("Enter Principal Amount: ");
            double principal = sc.nextDouble();

            System.out.print("Enter Loan Period (years): ");
            int period = sc.nextInt();

            System.out.print("Enter Loan Type (1 for PersonalLoan, 2 for HomeLoan): ");
            int loanType = sc.nextInt();

            if (loanType == 1) {
                loans[loanCount] = new PersonalLoan(principal, period);
            } else if (loanType == 2) {
                loans[loanCount] = new HomeLoan(principal, period);
            } else {
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

        double totalEmi = 0;
        double totalTax = 0;
        double totalDiscount = 0;

        for (int i = 0; i < loanCount; i++) {
            Loan loan = loans[i];
            System.out.println();
            System.out.println("Loan Amount: " + loan.getPrincipal());
            System.out.println("Loan Type: " + loan.getClass().getSimpleName());

            float rate = loan.getRate();
            double interestAmount = (loan.getPrincipal() * rate * loan.getPeriod()) / 100;
            System.out.printf("Interest Rate: %.2f%%, \nInterest Amount: %.2f%n", rate, interestAmount);

            double emi = loan.getEMI();
            System.out.printf("EMI (per month): %.2f%n", emi);
            totalEmi += emi;

            if (loan instanceof Taxable) {
                double tax = ((Taxable) loan).getTax();
                System.out.printf("Tax Applicable: %.2f%n", tax);
                totalTax += tax;
                System.out.println("----------------------------------------------------------------");
            }

            if (loan instanceof Discountable) {
                double discount = ((Discountable) loan).getDiscount();
                System.out.printf("Discount Applicable: %.2f%n", discount);
                totalDiscount += discount;
                System.out.println("----------------------------------------------------------------");
            }

            System.out.println(); 
        }

        System.out.printf("Total EMI for all loans: %.2f%n", totalEmi);
        System.out.printf("Total Tax for all Personal Loans: %.2f%n", totalTax);
        System.out.printf("Total Discount for all Home Loans: %.2f%n", totalDiscount);

        sc.close();
    }
}