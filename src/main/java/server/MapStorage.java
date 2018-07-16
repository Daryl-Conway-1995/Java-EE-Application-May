package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import accounts.Account;
import constants.Constants;
import util.JsonConverter;

@Alternative
@ApplicationScoped
public class MapStorage implements Storage {

	private HashMap<Long, Account> map;
	private Authentication auth;
	private Long id;
	
	@Inject
	private JsonConverter jsonCon;
	
	public MapStorage() {
		this.map = new HashMap<Long, Account>();
		this.id = 0L;
	}
	
	public String getAccount(Long id) {
		if(map.containsKey(id)) {
			return jsonCon.objectToJson(map.get(id));
		}
		else {
			return Constants.ERROR_MESSAGE;
		}
	}

	public String deleteAccount(Long id) {
		if (map.containsKey(id)) {
			map.remove(id);
			return Constants.DELETE_MESSAGE+id;
		} else {
			return Constants.ERROR_MESSAGE;
		}
	}

	public String addAccount(String StringAccount) {
		id++;
		Account newAccount = jsonCon.jsonToObject(StringAccount,Account.class);
		newAccount.setId(id);
		map.put(id, newAccount);
		return Constants.ADDITION_MESSAGE;
	}
	
	public String getAllAccounts(){
		return jsonCon.objectToJson(map.values());
	}

	public String updateAccount(Long id, String account) {
		if (map.keySet().contains(id)) {
			Account alteredAccount = jsonCon.jsonToObject(account, Account.class);
			alteredAccount.setId(id);
			map.replace(id, alteredAccount);
			return Constants.ACCOUNT_UPDATED;
		} else {
			return Constants.ACCOUNT_REJECTED;
		}
	}

}
