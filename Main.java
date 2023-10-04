import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Please enter your department from the following:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        
        int departmentChoice = scanner.nextInt();
        String department = "";

        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "HumanResource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        Employee employee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService();
        credentialService.showCredentials(employee, department);

        scanner.close();
    }
}
