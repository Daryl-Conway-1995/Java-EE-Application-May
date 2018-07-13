package interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import accounts.Account;
import server.Storage;

@Path("/account")
public class Application {

	@Inject
	private Storage storage;
	
	@Path("/all")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return storage.getAllAccounts();
	}
	@Path("/add")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return storage.addAccount(account);
	}

	@Path("/update/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return storage.updateAccount(account);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return storage.deleteAccount(id);

	}

	public void setService(Storage storage) {
		this.storage = storage;
	}

}
