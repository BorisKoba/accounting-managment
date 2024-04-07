package telran.security.accounting.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Value("${app.password.strength:10}")
	int strength;
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(strength);
	}
	@Bean
	SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception  {
		httpSecurity.cors(customizer -> customizer.disable());
		httpSecurity.csrf(customizer -> customizer.disable());
		httpSecurity.authorizeHttpRequests(customizer ->
		customizer.requestMatchers(HttpMethod.DELETE).hasRole("USER")
		.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
		.requestMatchers(HttpMethod.PUT).authenticated());
		httpSecurity.sessionManagement(customizer ->
		customizer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		httpSecurity.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
}