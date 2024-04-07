package telran.security.accounting.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.security.accounting.model.Account;
import telran.security.accounting.repo.AccountRepository;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
final AccountRepository accountRepo;
@Value("${app.root.password}")
String rootPassword;
@Value("${app.root.username:root@com.il}")
String rootUsername;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = null;
		if(!email.equals(rootUsername)) {
			Account account = accountRepo.findById(email).orElseThrow(()->new UsernameNotFoundException(""));
			String[] roles = Arrays.stream(account.getRoles()).map(r -> "ROLE_" + r).toArray(String[]::new);
			user = new User(email, account.getHashPassword(),
					AuthorityUtils.createAuthorityList(roles));
		} else {
			user = new User(rootUsername, rootPassword, AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
		}
		
		return user;
	}

}