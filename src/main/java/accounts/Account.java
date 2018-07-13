package accounts;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column 
	@Size (min=6, max=6)
	private String AccountNumber;
	@Column (length = 50)
	private String firstName;
	@Column (length = 50)
	private String lastName;
	
	/*
	@OneToMany
	@JoinColumn(name="fk_transaction")
	private List<Transaction> transactions;
	*/
	
	public Account()
	{
		this.AccountNumber = "000001";
		this.firstName = "place";
		this.lastName = "holder";
	}
	
	public Account(String accountNumber, String firstName, String lastName) {
		this.AccountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "account [AccountNumber=" + AccountNumber + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
