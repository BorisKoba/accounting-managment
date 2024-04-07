package telran.security.accounting.service;

import telran.security.accounting.dto.AccountDto;

public interface AccountingService {
AccountDto addAccount(AccountDto accountDto);
AccountDto removeAccount(String email);
void updatePassword(String email, String newPassword);
}