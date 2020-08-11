package Source;

import java.util.Scanner;

public class Main {
	
	private static final int INPUT_DATA = 1;
	private static final int SEARCH_DATA = 2;
	private static final int DELETE_DATA = 3;
	private static final int SHOW_ALL_DATA = 4;
	private static final int EXIT = 5;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name = "";
		int select = 0;
		
		PhoneBookManager m = new PhoneBookManager();
		
		
		while(true) {
			/* nextLine() 없애도 버퍼 문제 없이 마우스 포인터 넣으면 되는지 검사 필요 */
			
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 데이터 전체 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("\n" + "선택 : ");
			
			try { 
			select = sc.nextInt();
			if(select > EXIT)
				throw new Exception();
			switch(select) {
			case INPUT_DATA:
				m.inputInfo(select);
				break;
			case SEARCH_DATA:
				if(m.info.isEmpty()) {
					System.out.println("현재 데이터가 없습니다.");
					break;
				}
				System.out.println("데이터의 검색을 시작합니다.");
				System.out.print("이름 : ");
				name = sc.next();
				m.searchInfo(name);
				sc.nextLine();
				break;
			case DELETE_DATA:
				if(m.info.isEmpty()) {
					System.out.println("현재 데이터가 없습니다.");
					break;
				}
				System.out.println("데이터의 삭제를 시작합니다.");
				System.out.print("이름 : ");
				name = sc.next();
				m.deleteInfo(name);
				sc.nextLine();
				break;
			case SHOW_ALL_DATA:
				m.showPhoneInfo();
				break;
			case EXIT:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		}
		catch (Exception e) {
			System.out.println(select + "에 해당하는 선택은 존재하지 않습니다. 메뉴 선택을 처음부터 다시 진행해 주시기 바랍니다.");
			}
		}
	}
}
