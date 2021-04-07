package hu.ak_akademia.oop.bergengocy;

/**
 * <b>Exercise: Bergengocian Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Class to check if a given phone number is a legal mobile number in Bergengocy.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
class PhoneNumberChecker {

	private static final String FILTER_OUT_CHARS = "()- "; // allowed but ignored chars in phone numbers
	private static final String COUNTRY_PREFIX = "355"; // Bergengocy's country code
	private static final String INTL_PREFIX1 = "00" + COUNTRY_PREFIX; // prefix #1 for international distance calls
	private static final String INTL_PREFIX2 = "+" + COUNTRY_PREFIX; // prefix #2 for international distance calls
	private static final String DOMESTIC_PREFIX = "06"; // prefix for domestic distance calls
	private static final int LOCAL_NUMBER_LEN_MIN = 5; // minimum and maximum length of
	private static final int LOCAL_NUMBER_LEN_MAX = 7; // local phone numbers (without prefixes and area code)

	/**
	 * Check and clean a raw mobile phone number.
	 *
	 * @param rawPhoneNumber raw mobile phone number (entered by the user) to clean
	 * @return the phone number with prefix removed and cleaned (consisting of the area code and the local number)
	 * @throws IllegalArgumentException if the specified phone number contains illegal characters
	 */
	String clean(String rawPhoneNumber) {
		String phoneNumber = rawPhoneNumber;
		for (String s : FILTER_OUT_CHARS.split("")) { // filter out chars '(', ')', '-', ' '
			phoneNumber = phoneNumber.replace(s, "");
		}
		for (String prefix : new String[] { INTL_PREFIX1, INTL_PREFIX2, DOMESTIC_PREFIX }) { // filter out prefix (international or domestic)
			if (phoneNumber.startsWith(prefix)) {
				phoneNumber = phoneNumber.substring(prefix.length());
				break;
			}
		}
		for (char c : phoneNumber.toCharArray()) { // check if all characters are digits
			if ("0123456789".indexOf(c) < 0) {
				throw new IllegalArgumentException("A megadott telefonszám nem értelmezhető!");
			}
		}
		return phoneNumber;
	}

	/**
	 * Check (the length of) a local phone number.
	 *
	 * @param localPhoneNumber mobile number without prefix and area code
	 * @throws IllegalArgumentException if the specified local phone number is too short or too long
	 */
	void checkLocalNumber(String localPhoneNumber) {
		int length = localPhoneNumber.length();
		if (length < LOCAL_NUMBER_LEN_MIN || length > LOCAL_NUMBER_LEN_MAX) {
			throw new IllegalArgumentException("A megadott telefonszám körzeten belüli része hibás!");
		}
	}

}
