package email_app;

import java.util.Scanner;

/*
 * Generate an email with following syntax: firstnam.lastname@department.company.com
 * Determine the department(sales, development, accounting), if none leave blank
 * Generate random String for a password
 * Have set methods to change the password, set the mailbox capacity, and define an alternate email address
 * Have get methods to display the name, email, and mailbox capacity
 */
public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String companySuffix = "somecompany.com";
	private int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

		// Call a method asking for the department - return the department
		this.department = setDepartment();
		// System.out.println("Department: " + this.department);

		// Call a method that return a random password
		this.password = generateRandomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		// System.out.println("Your email is: " + email);
	}

	// Ask for the department
	private String setDepartment() {
		System.out.print("New worker: " + firstName
				+ ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner scanner = new Scanner(System.in);
		int depChoice = scanner.nextInt();
		switch (depChoice) {
		case 1:
			scanner.close();
			return "sales";
		case 2:
			scanner.close();
			return "dev";
		case 3:
			scanner.close();
			return "acct";
		default:
			scanner.close();
			return "";
		}

	}

	// Generate a random password
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%"; // <-- 30 character
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}

		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email

	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity + "mb";
	}

}
