package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import accounts.Account;
import constants.Constants;
import util.JsonConverter;

@Alternative
public class MapStorage implements Storage {

	private HashMap<Long, Account> map = new HashMap<Long, Account>();
	private Authentication auth;
	
	@Inject
	private JsonConverter jsonCon;
	
	public String getAccount(Long id) {
		if(map.containsKey(id)) {
			return jsonCon.objectConvert(map.get(id));
		}
		else {
			return Constants.ERROR_MESSAGE;
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

	public String addAccount(String StringAccount) {
		Account account = jsonCon.jsonConvert(StringAccount, Account.class);
		if(auth.isBanned(account.getId())) {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		}
		else {
			if (map.containsKey(account.getId())) {
				return Constants.COLLISION_MESSAGE;
			} else {
				map.put(account.getId(), account);
				return Constants.ADDITION_MESSAGE;
			}
		}
	}
	
	public String getAllAccounts(){
		List<Account> list;
		if (map.values() instanceof List)
		  list = (List<Account>)map.values();
		else
		{
		  list = new ArrayList<Account>(map.values());
		}
		return jsonCon.objectConvert(list);
	}

	public String updateAccount(String account) {
		Account newobj =jsonCon.jsonConvert(account, Account.class);
		map.replace(newobj.getId(), newobj);
		return jsonCon.objectConvert(map.get(newobj.getId()));
	}

}
