package pojos;
import java.util.Date;
public class ExpensesPojo {
	
	@Override
	public String toString() {
		return "ExpensesPojo [expId=" + expId + ", expAc=" + expAc + ", userId=" + userId + ", expCatId=" + expCatId
				+ ", amount=" + amount + ", tranDate=" + tranDate + ", payBy=" + payBy + ", remark=" + remark + "]";
	}
	public ExpensesPojo() {
		super();
	}
	public ExpensesPojo(String expAc, int userId, int expCatId, double amount, Date tranDate, String payBy,
			String remark) {
		super();
		this.expAc = expAc;
		this.userId = userId;
		this.expCatId = expCatId;
		this.amount = amount;
		this.tranDate = tranDate;
		this.payBy = payBy;
		this.remark = remark;
	}
	public ExpensesPojo(int expId, String expAc, int userId, int expCatId, double amount, Date tranDate, String payBy,
			String remark) {
		super();
		this.expId = expId;
		this.expAc = expAc;
		this.userId = userId;
		this.expCatId = expCatId;
		this.amount = amount;
		this.tranDate = tranDate;
		this.payBy = payBy;
		this.remark = remark;
	}
	public int getExpId() {
		return expId;
	}
	public void setExpId(int expId) {
		this.expId = expId;
	}
	public String getExpAc() {
		return expAc;
	}
	public void setExpAc(String expAc) {
		this.expAc = expAc;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExpCatId() {
		return expCatId;
	}
	public void setExpCatId(int expCatId) {
		this.expCatId = expCatId;
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
	public String getPayBy() {
		return payBy;
	}
	public void setPayBy(String payBy) {
		this.payBy = payBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private int expId;
	private String expAc;
	private int userId;
	private int expCatId;
	private double amount;
	private Date tranDate;
	private String payBy;
	private String remark;
}
