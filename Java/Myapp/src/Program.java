
import hospital.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Days Admitted:");
        int days = sc.nextInt();
        sc.nextLine();  // Consume the newline left by nextInt

        System.out.println("Name of Patient:");
        String name = sc.nextLine();

        System.out.println("Select Bed Type (ECONOMICAL, STANDARD, LUXURY):");
        String bedTypeInput = sc.nextLine().toUpperCase();

        System.out.println("Patient Type (InHouse Patient OR NormalPatient): ");

        String data = sc.nextLine().toUpperCase();


        BedType bedType;
        try {
            bedType = BedType.valueOf(bedTypeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid bed type. Defaulting to ECONOMICAL.");
            bedType = BedType.ECONOMICAL;
        }

        switch (data) {
            case "INHOUSE":
                Inhouse in = new Inhouse(101, name, days, bedType, 0);
                System.out.println("\nInhouse Patient\n");
                System.out.println("Patient Name: " + in.getName());
                System.out.println("Patient ID: " + in.getPatientId());
                System.out.println("Net Amount: " + in.GetAmount());
                break;
            case "NORMALPATIENT":
                Patient pa = new Patient(100, days, name, bedType);
                System.out.println("\nPatient\n");
                System.out.println("Patient Name: " + pa.getName());
                System.out.println("Patient ID: " + pa.getPatientId());
                System.out.println("Net Amount: " + pa.GetAmount());
                break;
            default:
                System.out.println("Invalid Patient type");    
                break;
        }
        sc.close();
    }
}

