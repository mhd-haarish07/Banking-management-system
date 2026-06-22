package model;

public class Account {

	private long accNo;
	
	private double accBal;
	
	public Account() {}
	
	public Account(long accNo, double accBal) {
		this.accNo = accNo;
		this.accBal = accBal;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
		
}
