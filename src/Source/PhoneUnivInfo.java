package Source;

public class PhoneUnivInfo extends PhoneInfo {
	
	private String major;
	private String year;
	
	public PhoneUnivInfo(String name, String phoneNumber, String major, String year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
}



