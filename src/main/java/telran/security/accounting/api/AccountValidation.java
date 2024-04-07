package telran.security.accounting.api;

public interface AccountValidation {
	String MISSING_EMAIL = "Email address is not valid";
	String PASSWORD_SIZE = "\\d{8}";
	String PASSWORD_WRONG_LENGTH = "Number must consist of exactly 8 digits";
	String MISSING_ROLE = "Must contain at least one role";
}
