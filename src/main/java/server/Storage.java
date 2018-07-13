package server;

import java.util.List;

import accounts.Account;

public interface Storage {

	Account getAccount(Long id);
	
	String deleteAccount(Long id);
	
	String addAccount(Account account);
	
	List<Account> getAllAccounts();
	
	 public Account updateAccount(Account account,String firstName,String lastName,String accountNumber); 
}
