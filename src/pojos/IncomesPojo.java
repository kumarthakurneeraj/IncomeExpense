package pojos;

import java.util.Date;

public class IncomesPojo {
	@Override
	public String toString() {
		return "IncomesPojo [incId=" + incId + ", incAc=" + incAc + ", userId=" + userId + ", incCatid=" + incCatid
				+ ", amount=" + amount + ", tranDate=" + tranDate + ", receiveBy=" + receiveBy + ", remark=" + remark
				+ "]";
	}
	public IncomesPojo() {
		super();
	}
	public IncomesPojo(String incAc, int userId, int incCatid, double amount, Date tranDate, String receiveBy,
			String remark) {
		super();
		this.incAc = incAc;
		this.userId = userId;
		this.incCatid = incCatid;
		this.amount = amount;
		this.tranDate = tranDate;
		this.receiveBy = receiveBy;
		this.remark = remark;
	}
	public IncomesPojo(int incId, String incAc, int userId, int incCatid, double amount, Date tranDate,
			String receiveBy, String remark) {
		super();
		this.incId = incId;
		this.incAc = incAc;
		this.userId = userId;
		this.incCatid = incCatid;
		this.amount = amount;
		this.tranDate = tranDate;
		this.receiveBy = receiveBy;
		this.remark = remark;
	}
	public int getIncId() {
		return incId;
	}
	public void setIncId(int incId) {
		this.incId = incId;
	}
	public String getIncAc() {
		return incAc;
	}
	public void setIncAc(String incAc) {
		this.incAc = incAc;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIncCatid() {
		return incCatid;
	}
	public void setIncCatid(int incCatid) {
		this.incCatid = incCatid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public String getReceiveBy() {
		return receiveBy;
	}
	public void setReceiveBy(String receiveBy) {
		this.receiveBy = receiveBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private int incId;
	private String incAc;
	private int userId;
	private int incCatid;
	private double amount;
	private Date tranDate;
	private String receiveBy;
	private String remark;
}
