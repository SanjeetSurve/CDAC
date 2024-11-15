package app.components;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ithe aapn array ghetla class cha toh pn size of 10 cha manje max. 10
        Loan[] loans = new Loan[10];

        // check karnya sathi ki kiti loan gehtle
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
                // ithe aapn basically LoanFactory class la call kartoy [loanCount] ha indexing provide karto ki PersonalLoan kivha HomeLoan hey type save hoil
                loans[loanCount] = LoanFactory.createLoan(loanType, principal, period);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid loan type selected. Defaulting to PersonalLoan.");

                // kahi invalid aala tar mg default la ithe aapn PersonalLoan karto
                loans[loanCount] = new PersonalLoan(principal, period);
            }
            // Loan create jhali mg dusrya loan sathi count increase karaycha 
            loanCount++;

            System.out.print("Do you want to add another loan? (yes/no): ");
            String choice = sc.next();

            // ithe aapn check karto ki basically aaplyala loan add karyacha aahe ka aajun kahi ki nhi
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        double totalEmi = 0, totalTax = 0, totalDiscount = 0;

        // ha basically tya sarv loan na calculate karto 
        // aani sarvan varun iterate karto
        for (int i = 0; i < loanCount; i++) {
            Loan loan = loans[i];
            LoanFactory.printLoanDetails(loan);

            totalEmi += loan.getEMI();
            // Taxable instance aasel tar Tax calculate karel
            if (loan instanceof Taxable taxable) totalTax += taxable.getTax();
            // Discountable instance aasel tar Tax calculate karel
            if (loan instanceof Discountable discountable) totalDiscount += discountable.getDiscount();
        }

        System.out.printf("Total EMI for all loans: %.2f%n", totalEmi);
        System.out.printf("Total Tax for all Personal Loans: %.2f%n", totalTax);
        System.out.printf("Total Discount for all Home Loans: %.2f%n", totalDiscount);

        sc.close();
    }
}