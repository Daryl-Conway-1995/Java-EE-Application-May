package server;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import accounts.Account;
import constants.Constants;
import util.JsonConverter;

@Transactional(TxType.SUPPORTS)
public class AccountServiceDB implements Storage{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private Authentication auth = new Authentication();
	
	@Inject
	private JsonConverter jsonCon;

	public String getAllAccounts() {
        TypedQuery<Account> query = manager.createQuery(Constants.FIND_ALL_ACCOUNTS, Account.class);
        Collection<Account> accounts = (Collection<Account>) query.getResultList();
        return jsonCon.objectConvert(accounts);
	}
        
    public String getAccount(Long id) {
            return jsonCon.objectConvert(manager.find(Account.class, id));
     }
    
    @Transactional(TxType.REQUIRED)
    public String deleteAccount(Long id) {
    	manager.remove(manager.find(Account.class, id));
//    	manager.createQuery("DELETE a FROM Account a WHERE a.id ="+id, Account.class);
    	return Constants.DELETE_MESSAGE;
    	//Constants.DELETE_ACCOUNT
    }
    
    @Transactional(TxType.REQUIRED)
    public String updateAccount(String account) {
    	Account updatedAccount = jsonCon.jsonConvert(account, Account.class);
    	manager.refresh(updatedAccount);
    	return jsonCon.objectConvert(account);
    }
    
    @Transactional(TxType.REQUIRED)
    public String addAccount(String newAccount) {
    	Account account = jsonCon.jsonConvert(newAccount, Account.class);
    	if(auth.isBanned(account.getId())) { 
        	return Constants.BANNED_ACCOUNT_MESSAGE;
    	}
   		manager.persist(account);
    	return Constants.ADDITION_MESSAGE;
    }
}