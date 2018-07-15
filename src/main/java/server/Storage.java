package server;

import java.util.List;

import accounts.Account;

public interface Storage {

	String getAccount(Long id);
	
	String deleteAccount(Long id);
	
	String addAccount(String account);
	
	String getAllAccounts();
	
	String updateAccount(Long id, String account); 
}
