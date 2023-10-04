import java.util.Random;

public class CredentialService {
    private static final String companyName = "GreatLearning";

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(characters.charAt(random.nextInt(26))); // Capital Letters
        password.append(characters.charAt(26 + random.nextInt(26))); // Small Letters
        password.append(characters.charAt(52 + random.nextInt(10))); // Numbers
        password.append("!@#$%^&*".charAt(random.nextInt(8))); // Special Characters

        for (int i = 4; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        // Shuffle
        String shuffledPassword = shuffleString(password.toString());
        return shuffledPassword;
    }

    private String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = new Random().nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

    public String generateEmailAddress(String firstName, String lastName, String department) {
      String departmentShort = "";
    switch (department.toLowerCase()) {
        case "technical":
            departmentShort = "tech";
            break;
        case "admin":
            departmentShort = "admin";
            break;
        case "humanresource":
            departmentShort = "hr";
            break;
        case "legal":
            departmentShort = "legal";
            break;
        default:
            break;
    }
        String email = firstName.toLowerCase() +  lastName.toLowerCase() + "@" + departmentShort.toLowerCase() + "." + companyName.toLowerCase() + "." + "com";
        return email;
    }

    public void showCredentials(Employee employee, String department) {
        String email = generateEmailAddress(employee.getFirstName(), employee.getLastName(), department);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}
