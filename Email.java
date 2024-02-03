import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLen;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.defaultPasswordLen = passwordSize();

        this.password = randomPassword(defaultPasswordLen);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + "camere.com";

        this.mailboxCapacity = setMailCapacity();
    }

    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Accounting\n3 for IT\n0 for None.\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch(depChoice) {
            case 1:
                return "sales";
            case 2:
                return "accounting";
            case 3:
                return "IT";
            default:
                return "None";
        }
    }

    //Super special Password Generation Method
    private String randomPassword(int len) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&*?@";
        char[] password = new char[len];
        for(int i = 0; i <len; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private int passwordSize() {
        System.out.println("DESIRED PASSWORD LENGTH:");
        Scanner in = new Scanner(System.in);
        int passSize = in.nextInt();
        return passSize;
    }

    private int setMailCapacity() {
        System.out.println("DESIRED EMAIL CAPACITY:");
        Scanner in = new Scanner(System.in);
        int mailCap = in.nextInt();
        return mailCap;
    }

    public void setAlternateEmail(String altMail) {
        this.alternateEmail = altMail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY  NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "Mb";
    }
}
