package pojos;

import java.util.Date;

public class BankBookPojo {

	@Override
	public String toString() {
		return "BookBankPojo [acId=" + acId + ", account=" + account + ", tranDate=" + tranDate + ", amount=" + amount
				+ ", userId=" + userId + ", operation=" + operation + "]";
	}
	public BankBookPojo() {
		super();
	}
	public BankBookPojo(String account, Date tranDate, double amount, int userId, String operation) {
		super();
		this.account = account;
		this.tranDate = tranDate;
		this.amount = amount;
		this.userId = userId;
		this.operation = operation;
	}
	public BankBookPojo(int acId, String account, Date tranDate, double amount, int userId, String operation) {
		super();
		this.acId = acId;
		this.account = account;
		this.tranDate = tranDate;
		this.amount = amount;
		this.userId = userId;
		this.operation = operation;
	}
	public int getAcId() {
		return acId;
	}
	public void setAcId(int acId) {
		this.acId = acId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	private int acId;
	private String account;
	private Date tranDate;
	private double amount;
	private int userId;
	private String operation;
	
}
