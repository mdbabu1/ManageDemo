package system;

public class Lease {
	private int tenantId;
	private int landLordId;
	private String address; 
	private String leaseStart;
	private String leaseEnd;
	private double rentPrice;
	
	public Lease() {
	  	
    }
	public Lease(int tenant, int landLord, String address, String leaseStart, String leaseEnd, double rentPrice) {
	  	this.tenantId = tenant;
	  	this.landLordId = landLord;
	  	this.address = address;
	  	this.leaseStart = leaseStart;
	  	this.leaseEnd = leaseEnd;
	  	this.rentPrice = rentPrice;
    }
	//Getter methods
	public int getTenantId() {
		return this.tenantId;
	}
	public int getLandLordId() {
		return this.landLordId;
	}
	public String getAddress() {
		return this.address;
	}
	public String getLeaseStart() {
		return this.leaseStart;
	}
	public String getLeaseEnd() {
		return this.leaseEnd;
	}
	public double getRentPrice() {
		return this.rentPrice;
	}
	//Setter methods
	public void setTenant(int tenantId) {
		this.tenantId = tenantId;
	}
	public void setLandLord(int landLordId) {
		this.landLordId = landLordId;
	}
	public void setAddress(String property) {
		this.address = property;
	}
	public void setLeaseStart(String leaseStart) {
		this.leaseStart = leaseStart;
	}
	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
