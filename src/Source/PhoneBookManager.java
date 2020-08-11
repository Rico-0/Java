package Source;

import java.util.*;


/* ArrayList 버전. 다시 Array로 바꾸기 */
/* HashMap 버전으로도 만들어 보기 */

public class PhoneBookManager {
	
	private static final int DEFAULT = 1;
	private static final int UNIVERSITY = 2;
	private static final int COMPANY = 3;
	
	ArrayList<PhoneInfo> info; // 정보 담는 배열
	
	public PhoneBookManager() {
		info = new ArrayList<>(); // 생성자로 객체 생성 시 ArrayList를 생성
	}
	
	public void inputInfo(int select) {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반");
		System.out.println("2. 대학");
		System.out.println("3. 회사");
		String name = "";
		String phoneNumber = "";
		String major = "";
		String year = "";
		String company = "";
		Scanner sc = new Scanner(System.in);
		try {
		select = sc.nextInt();
		if(select > COMPANY)
			throw new Exception();
		switch(select) {
		case DEFAULT:
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("전화번호 : ");
			phoneNumber = sc.next();
			sc.nextLine(); // Enter 키 받기
			if(!checkSameName(name)) {
				info.add(new PhoneInfo(name,phoneNumber));
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			break;
		case UNIVERSITY:
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("전화번호 : ");
			phoneNumber = sc.next();
			System.out.print("전공 : " );
			major = sc.next();
			System.out.print("학년 : ");
			year = sc.next();
			if(!checkSameName(name)) {
				info.add(new PhoneUnivInfo(name,phoneNumber,major,year));
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			break;
		case COMPANY:
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("전화번호 : ");
			phoneNumber = sc.next();
			System.out.print("회사  : ");
			company = sc.next();
			if(!checkSameName(name)) {
				info.add(new PhoneCompanyInfo(name,phoneNumber,company));
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			break;
			}
		} catch (Exception e) {
			System.out.println(select + "에 해당하는 선택은 존재하지 않습니다. 메뉴 선택을 처음부터 다시 진행해 주시기 바랍니다.");
		}
	}
	
	
	/* 우리는 동명이인은 없다고 가정할 것이므로 동명이인의 데이터가 존재하는지 검사 */
	public boolean checkSameName(String name) {
		Iterator<PhoneInfo> itr = info.iterator();
		while(itr.hasNext()) {
			PhoneInfo tmp = itr.next();
			if(tmp.getName().equals(name)) {
				System.out.println("이름이 같은 사람이 이미 있습니다.");
				return true;
			}
		}
		return false;
	}
	
	/* 데이터의 검색 */
	public boolean searchInfo(String name) {
		int i = 0;
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)){
				if(info.get(i) instanceof PhoneCompanyInfo) {
					System.out.println("=======================================" + "\n"
							+ "이름 : " + info.get(i).getName() + "\n"
							+ "전화번호 : " + info.get(i).getPhoneNumber() + "\n"
							+ "회사 : " + ((PhoneCompanyInfo) info.get(i)).getCompany() + "\n"
							+ "=======================================" + "\n");
				}
				else if (info.get(i) instanceof PhoneUnivInfo) {
					System.out.println("=======================================" + "\n"
							+ "이름 : " + info.get(i).getName() + "\n"
							+ "전화번호 : " + info.get(i).getPhoneNumber() + "\n"
							+ "전공 : " + ((PhoneUnivInfo) info.get(i)).getMajor() + "\n"
							+ "학년 : " + ((PhoneUnivInfo) info.get(i)).getYear() + "\n"
							+ "=======================================" + "\n");
				}
				else {
					System.out.println("=======================================" + "\n"
							+ "이름 : " + info.get(i).getName() + "\n"
							+ "전화번호 : " + info.get(i).getPhoneNumber() + "\n"
							+ "=======================================" + "\n");
				}
				return true;
			}
		}
		if(i >= info.size()) {
			System.out.println("일치하는 데이터가 없습니다.");
			return false;
		}
		return false;
	}
	
	/* 데이터의 삭제 */
	public void deleteInfo(String name) {
		int i = 0;
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)) {
				info.remove(i);
				System.out.println("데이터 삭제가 완료되었습니다.");
				return;
			}
		}
		if(i >= info.size())
			System.out.println("일치하는 데이터가 없습니다.");
	}
	
	/* 데이터 수정 : 아직 완성 안 함.. */
	/* public void modifyInfo(String name) throws IndexOutOfBoundsException {
		// 수정 전 먼저 해당 데이터가 있는지 이름으로 검사
		int i = 0;
		Scanner sc = new Scanner(System.in);
		// 예외 처리 아직 구현 안 함
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)) // 일치하는 이름이 있을 경우 반복문 종료
				break;
		}
		
		if(i >= info.size()) {
			System.out.println("해당하는 데이터가 없습니다.");
			return;
		}
		
		PhoneInfo tmp = info.get(i); // 위 반복문에서 얻은 값을 임시 PhoneInfo 객체에 저장
		
		String[] newInfo = new String[3]; // 변수 3개를 선언해도 되지만 그냥 배열로 묶었다.
		
		// 수정할 데이터가 전체일 수도 있고, 하나 혹은 두 개일 수도 있으므로 각각의 경우를 체크해 준다.
		// 수정할 경우 true, 수정하지 않을 경우 false
		boolean[] ischecked = new boolean[3];
		int[] input = new int[2];
		Arrays.fill(ischecked, false); // 초기값은 전부 false인 상태
		System.out.println("수정할 데이터를 선택하세요. 수정하지 않을 데이터는 0으로 적어주세요.");
		//System.out.println("예) 전화번호와 생년월일 수정 : 0  , 모두 수정 : 1 2 3");
		System.out.println("1. 이름");
		System.out.println("2. 전화번호");
		
		
		for(i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
			if(input[i] > 0)
				ischecked[i + 1] = true;
		}
		
		for(i = 1; i < ischecked.length; i++) {
			if(ischecked[i] && i == 1) {
				System.out.print("수정할 이름 입력 : ");
				newInfo[0] = sc.next();
				tmp.setName(newInfo[0]);
			}else if(ischecked[i] && i == 2) {
				System.out.print("수정할 전화번호 입력 : ");
				newInfo[1] = sc.next();
				tmp.setPhoneNumber(newInfo[1]);
			}
		}
	} */
	
	/* 데이터 전부 출력 */
	public void showPhoneInfo() {
		Iterator<PhoneInfo> itr = info.iterator();
		if(info.isEmpty()) {
			System.out.println("저장되어 있는 데이터가 없습니다.");
			return;
		}
		while(itr.hasNext()) {
			PhoneInfo tmp = itr.next();
			if(tmp instanceof PhoneUnivInfo) {
				System.out.println("=======================================" + "\n"
						+ "이름 : " + tmp.getName() + "\n"
						+ "전화번호 : " + tmp.getPhoneNumber() + "\n"
						+ "전공 : " + ((PhoneUnivInfo)tmp).getMajor() + "\n"
						+ "학년 : " + ((PhoneUnivInfo) tmp).getYear() + "\n"
						+ "========================================");
			}
			else if(tmp instanceof PhoneCompanyInfo) {
				System.out.println("=======================================" + "\n"
						+ "이름 : " + tmp.getName() + "\n"
						+ "전화번호 : " + tmp.getPhoneNumber() + "\n"
						+ "회사 : " + ((PhoneCompanyInfo) tmp).getCompany() + "\n"
						+ "========================================");
			}
			else 
				{
				System.out.println("=======================================" + "\n"
						+ "이름 : " + tmp.getName() + "\n"
						+ "전화번호 : " + tmp.getPhoneNumber() + "\n"
						+ "========================================");
				}			
			}
		}
	}
