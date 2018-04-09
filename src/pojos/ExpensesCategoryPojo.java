package pojos;

public class ExpensesCategoryPojo {
	
	@Override
	public String toString() {
		return "ExpensesCategoryPojo [expCatId=" + expCatId + ", expCatName=" + expCatName + ", expCatDetails="
				+ expCatDetails + ", userId=" + userId + "]";
	}
	public ExpensesCategoryPojo() {
		super();
	}
	public ExpensesCategoryPojo(String expCatName, String expCatDetails, int userId) {
		super();
		this.expCatName = expCatName;
		this.expCatDetails = expCatDetails;
		this.userId = userId;
	}
	public ExpensesCategoryPojo(int expCatId, String expCatName, String expCatDetails, int userId) {
		super();
		this.expCatId = expCatId;
		this.expCatName = expCatName;
		this.expCatDetails = expCatDetails;
		this.userId = userId;
	}
	public int getExpCatId() {
		return expCatId;
	}
	public void setExpCatId(int expCatId) {
		this.expCatId = expCatId;
	}
	public String getExpCatName() {
		return expCatName;
	}
	public void setExpCatName(String expCatName) {
		this.expCatName = expCatName;
	}
	public String getExpCatDetails() {
		return expCatDetails;
	}
	public void setExpCatDetails(String expCatDetails) {
		this.expCatDetails = expCatDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int expCatId;
	private String expCatName;
	private String expCatDetails;
	private int userId;
}
