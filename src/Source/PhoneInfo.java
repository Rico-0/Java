package Source;


public class PhoneInfo {
	
	private String name;
	private String phoneNumber;
	// private String birthday; �������� �����ε��� �ǽ��ϱ� ���� �����̹Ƿ� 4�ܰ迡���� �����Ѵ�.
	
	
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
