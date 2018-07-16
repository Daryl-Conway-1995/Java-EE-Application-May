package constants;

public class Constants {
	
	public static final String FIND_ALL_ACCOUNTS = "SELECT a FROM Account a ORDER BY a.id DESC";
	public static final String DELETE_ACCOUNT = "DELETE a FROM Account a WHERE a.id =";
	public static final String FIND_ONE_ACCOUNT = "SELECT a FROM Account a WHERE a.id =";
	public static final String DELETE_MESSAGE = "deleted account ";
	public static final String ADDITION_MESSAGE = "account added.";
	public static final String ERROR_MESSAGE = "Requested account can not be found.";
	public static final String COLLISION_MESSAGE = "An account all ready exists with that id.";
	public static final Long BANNED_ACCOUNT = 999999L;
	public static final String BANNED_ACCOUNT_MESSAGE = "This account is blocked";
	public static final String ACCOUNT_UPDATED = "{\"message\":\"Account number has been successfully updated\"}";
	public static final String ACCOUNT_REJECTED = "{\"message\":\"Account number has not been updated\"}";
}
