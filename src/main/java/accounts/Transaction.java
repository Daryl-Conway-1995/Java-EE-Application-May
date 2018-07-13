package accounts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Transaction {
	
	/*
	Insert INTO TRANSACTION (id,name) VALUES (1,'first_transaction')
	Insert INTO TRANSACTION (id,name) VALUES (2,'second_transaction')
	Insert INTO TRANSACTION (id,name) VALUES (3,'third_transaction')

	example of transaction creation
	*/
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column (length =50)
	private String name;
	
	public Transaction(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", name=" + name + "]";
	}

}
