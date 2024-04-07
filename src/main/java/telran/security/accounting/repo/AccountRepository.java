package telran.security.accounting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.security.accounting.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}