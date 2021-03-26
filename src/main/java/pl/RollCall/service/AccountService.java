package pl.RollCall.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.RollCall.exceptions.AccountNotFoundException;
import pl.RollCall.model.Account;
import pl.RollCall.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account, Long id) {
        Account accountToUpdate = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        accountToUpdate.setId(account.getId());
        accountToUpdate.setUsername(account.getUsername());
        accountToUpdate.setFirstName(account.getFirstName());
        accountToUpdate.setLastName(account.getLastName());
        accountToUpdate.setRoomsOwner(account.getRoomsOwner());
        accountToUpdate.setRooms(account.getRooms());
        return accountRepository.save(accountToUpdate);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
