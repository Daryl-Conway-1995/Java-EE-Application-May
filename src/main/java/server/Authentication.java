package server;
import constants.Constants;

public class Authentication {
	
		public String IdCheck(Long id) {
			if(id == Constants.BANNED_ACCOUNT) {
				return Constants.BANNED_ACCOUNT_MESSAGE;
			}
			else
			{
				return Constants.ADDITION_MESSAGE;
			}
		}
}
