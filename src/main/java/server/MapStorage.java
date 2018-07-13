package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;

import accounts.Account;
import constants.Constants;

@Alternative
public class MapStorage implements Storage {

	private HashMap<Long, Account> map = new HashMap<Long, Account>();
	private Authentication auth;
	
	public Account getAccount(Long id) {
		if(map.containsKey(id)) {
			return map.get(id);
		}
		else {
			return null;
		}
	}

	public String deleteAccount(Long id) {
		if (map.containsKey(id)) {
			map.remove(id);
			return id + Constants.DELETE_MESSAGE;
		} else {
			return Constants.ERROR_MESSAGE;
		}
	}

	public String addAccount(Account account) {
		if(Constants.ADDITION_MESSAGE.equals(auth.IdCheck(account.getId()))) {
			if (map.containsKey(account.getId())) {
				return Constants.COLLISION_MESSAGE;
			} else {
				map.put(account.getId(), account);
				return Constants.ADDITION_MESSAGE;
			}
		}
		else {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		}
	}
	
	public List<Account> getAllAccounts(){
		List<Account> list;
		if (map.values() instanceof List)
		  list = (List<Account>)map.values();
		else
		{
		  list = new ArrayList<Account>(map.values());
		}
		return list;
	}

	public Account updateAccount(Account account, String firstName, String lastName, String accountNumber) {
		account.setAccountNumber(accountNumber);
		account.setFirstName(firstName);
		account.setLastName(lastName);
		map.replace(account.getId(), account);
		return map.get(account.getId());
	}

}
