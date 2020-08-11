package Source;


public class PhoneInfo {
	
	private String name;
	private String phoneNumber;
	// private String birthday; 생성자의 오버로딩을 실습하기 위한 목적이므로 4단계에서는 삭제한다.
	
	
	PhoneInfo(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
