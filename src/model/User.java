package model;

public class User {

	private long accNo;

	private String userName;

	private int pin;

	private Account accDetails = new Account();

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public User(long accNo, String userName, double bal, int pin) {
		this.accNo = accNo;
		this.userName = userName;
		this.pin = pin;
		this.accDetails.setAccNo(accNo);
		this.accDetails.setAccBal(bal);
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Account getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(Account accDetails) {
		this.accDetails = accDetails;
	}

	@Override
	public String toString() {
		return "User [accNo : " + accNo + ", userName : " + userName + ", accBal : " + accDetails.getAccBal() + "]";
	}

}
