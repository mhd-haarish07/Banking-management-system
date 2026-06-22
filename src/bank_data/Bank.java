package bank_data;

import java.util.HashMap;
import java.util.Map;

import model.User;

public class Bank {

	private Map<Long, User> accounts = new HashMap<>();

	private BankService bs = new BankService();
	
	private String key = "secret";

	public String getKey() {
		return key;
	}

	public Bank() {
		if (accounts.isEmpty()) {
			accounts.put(2506101102l, new User(2506101102l, "Nithish", 25000, 1234));
			accounts.put(2506101103l, new User(2506101103l, "Goku", 6000, 1234));
			accounts.put(2506101104l, new User(2506101104l, "Murugan", 100000, 1234));
			accounts.put(2506101105l, new User(2506101105l, "Karthick", 8000, 1234));
			accounts.put(2506101106l, new User(2506101106l, "Ben", 10000, 1234));
		}
	}

	public User createAccount(String name, double bal, int pin) {

		long accNum = bs.accNumGen();

		this.accounts.put(accNum, new User(accNum, name, bal, pin));
		
		return accounts.get(accNum);
	}

	public Map<Long, User> getAccounts() {
		return accounts;
	}

	public void deposit(long id, double amount) throws Exception {

		if (!accounts.containsKey(id)) {
			throw new Exception("Account not found!");
		}

		User user = accounts.get(id);

		user.getAccDetails().setAccBal(user.getAccDetails().getAccBal() + amount);

		accounts.replace(id, user);
	}

	public void withDraw(long id, double amount) throws Exception {

		if (!accounts.containsKey(id)) {
			throw new Exception("Account not found!");
		}

		User user = accounts.get(id);

		if (user.getAccDetails().getAccBal() > amount) {
			
			user.getAccDetails().setAccBal(user.getAccDetails().getAccBal() - amount);
			accounts.replace(id, user);

		} else {
			
			System.out.println("Insufficient balance!");
		}
	}
	
	public User login(long id, int pin) {
		
		User user = accounts.get(id);
		
		if(user.getPin() == pin) {
			
			return user;
		} else {
			return null;
		}
	}
	
	public void showAcc() {
		
		for(Long key : accounts.keySet()) {
			System.out.println(accounts.get(key));
		}
	}
}
