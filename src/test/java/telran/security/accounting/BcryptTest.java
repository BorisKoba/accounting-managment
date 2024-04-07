package telran.security.accounting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class BcryptTest {
PasswordEncoder encoder ;
	@Test
	@Disabled
	void bcryptDefaultTest() {
		encoder = new BCryptPasswordEncoder();
		String password = "user1234";
		String hashCode = encoder.encode(password);
		assertTrue(encoder.matches(password, hashCode));
		assertFalse(encoder.matches("kuku", password));
	}
	@Test
	@Disabled
	void bcryptStrengthTest() {
		encoder = new BCryptPasswordEncoder(16);
		String password = "user1234";
		String hashCode = encoder.encode(password);
		assertTrue(encoder.matches(password, hashCode));
		assertFalse(encoder.matches("kuku", password));
	}

}
