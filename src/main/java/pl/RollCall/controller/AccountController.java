package pl.RollCall.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.RollCall.exceptions.AccountNotFoundException;
import pl.RollCall.model.Account;
import pl.RollCall.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id){
        return accountService.getAccountById(id).
                orElseThrow(() -> new AccountNotFoundException(id));
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable Long id){
        return accountService.updateAccount(account, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }





}
