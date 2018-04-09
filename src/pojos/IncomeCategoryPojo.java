package pojos;

public class IncomeCategoryPojo {
	@Override
	public String toString() {
		return "IncomeCategoryPojo [incCatId=" + incCatId + ", incCatName=" + incCatName + ", incCatDetails="
				+ incCatDetails + ", userId=" + userId + "]";
	}
	public int getIncCatId() {
		return incCatId;
	}
	public void setIncCatId(int incCatId) {
		this.incCatId = incCatId;
	}
	public String getIncCatName() {
		return incCatName;
	}
	public void setIncCatName(String incCatName) {
		this.incCatName = incCatName;
	}
	public String getIncCatDetails() {
		return incCatDetails;
	}
	public void setIncCatDetails(String incCatDetails) {
		this.incCatDetails = incCatDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public IncomeCategoryPojo() {
		super();
	}
	public IncomeCategoryPojo(String incCatName, String incCatDetails, int userId) {
		super();
		this.incCatName = incCatName;
		this.incCatDetails = incCatDetails;
		this.userId = userId;
	}
	public IncomeCategoryPojo(int incCatId, String incCatName, String incCatDetails, int userId) {
		super();
		this.incCatId = incCatId;
		this.incCatName = incCatName;
		this.incCatDetails = incCatDetails;
		this.userId = userId;
	}
	private int incCatId;
	private String incCatName;
	private String incCatDetails;
	private int userId;
}
