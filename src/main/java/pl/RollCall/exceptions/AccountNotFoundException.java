package pl.RollCall.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id){
        super("Account with ID : " + id + " does not exist!");
    }
}