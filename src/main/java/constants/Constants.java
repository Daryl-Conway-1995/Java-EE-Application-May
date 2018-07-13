package constants;

public class Constants {
	
	public static final String FIND_ALL_ACCOUNTS = "SELECT a FROM ACCOUNT a ORDER BY a.firstName DESC";
	public static final String DELETE_ACCOUNT = "DELETE a FROM ACCOUNT a WHERE a.id =";
	public static final String DELETE_MESSAGE = "account deleted.";
	public static final String ADDITION_MESSAGE = "account added.";
	public static final String ERROR_MESSAGE = "Requested account can not be found.";
	public static final String COLLISION_MESSAGE = "An account all ready exists with that id.";
	public static final Long BANNED_ACCOUNT = 999999L;
	public static final String BANNED_ACCOUNT_MESSAGE = "This account is blocked";

}
