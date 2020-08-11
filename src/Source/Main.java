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
			/* nextLine() ���ֵ� ���� ���� ���� ���콺 ������ ������ �Ǵ��� �˻� �ʿ� */
			
			System.out.println("�����ϼ���...");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ������ �˻�");
			System.out.println("3. ������ ����");
			System.out.println("4. ������ ��ü ���");
			System.out.println("5. ���α׷� ����");
			System.out.print("\n" + "���� : ");
			
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
					System.out.println("���� �����Ͱ� �����ϴ�.");
					break;
				}
				System.out.println("�������� �˻��� �����մϴ�.");
				System.out.print("�̸� : ");
				name = sc.next();
				m.searchInfo(name);
				sc.nextLine();
				break;
			case DELETE_DATA:
				if(m.info.isEmpty()) {
					System.out.println("���� �����Ͱ� �����ϴ�.");
					break;
				}
				System.out.println("�������� ������ �����մϴ�.");
				System.out.print("�̸� : ");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
			
		}
		catch (Exception e) {
			System.out.println(select + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�. �޴� ������ ó������ �ٽ� ������ �ֽñ� �ٶ��ϴ�.");
			}
		}
	}
}
