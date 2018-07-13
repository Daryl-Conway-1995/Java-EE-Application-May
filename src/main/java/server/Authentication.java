package server;
import constants.Constants;

public class Authentication {
	
		public boolean isBanned(Long id) {
			return id.equals(Constants.BANNED_ACCOUNT);
		}
}
