package email_app;

public class EmailApp {
	/*
	 * You are an IT Support Administrator Specialist and are charged with task of
	 * creating email accounts for new hires.
	 */
	public static void main(String[] args) {
		Email email = new Email("Ödön", "Kabát");
		System.out.println(email.showInfo());
	}

}
