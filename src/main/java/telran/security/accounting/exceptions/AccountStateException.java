package telran.security.accounting.exceptions;

@SuppressWarnings("serial")
public class AccountStateException extends IllegalStateException {
	public AccountStateException(String email) {
		super(String.format("account %s already exists", email));
	}
}
