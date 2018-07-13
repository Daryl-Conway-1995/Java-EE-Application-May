package server;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import accounts.Account;
import constants.Constants;

@Transactional(TxType.SUPPORTS)
public class AccountServiceDB implements Storage{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private Authentication auth;

	public List<Account> getAllAccounts() {
        TypedQuery<Account> query = manager.createQuery(Constants.FIND_ALL_ACCOUNTS, Account.class);
        return query.getResultList();
	}
        
    public Account getAccount(Long id) {
            return manager.find(Account.class, id);
     }
    
    @Transactional(TxType.REQUIRED)
    public String deleteAccount(Long id) {
    	manager.createQuery(Constants.DELETE_ACCOUNT+id, Account.class);
    	return Constants.DELETE_MESSAGE;
    }
    
    @Transactional(TxType.REQUIRED)
    public Account updateAccount(Account account,String firstName,String lastName,String accountNumber) {
    	account.setAccountNumber(accountNumber);
    	account.setFirstName(firstName);
    	account.setLastName(lastName);
    	manager.refresh(account);
    	return account;
    }
    
    @Transactional(TxType.REQUIRED)
    public String addAccount(Account newAccount) {
    	if(Constants.ADDITION_MESSAGE.equals(auth.IdCheck(newAccount.getId()))) {
    		manager.persist(newAccount);
            return Constants.ADDITION_MESSAGE;
    	}
    	else {
    		return Constants.BANNED_ACCOUNT_MESSAGE;
    	}
    }
}