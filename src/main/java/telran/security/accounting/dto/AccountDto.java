package telran.security.accounting.dto;
import jakarta.validation.constraints.*;
public record AccountDto(@NotEmpty(message="missing email") @Email(message="wrong email format") String email, @NotNull @Size(min=8)String password,
		@NotEmpty String[] roles ) {

}
