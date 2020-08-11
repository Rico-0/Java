package Source;

import java.util.*;


/* ArrayList ����. �ٽ� Array�� �ٲٱ� */
/* HashMap �������ε� ����� ���� */

public class PhoneBookManager {
	
	private static final int DEFAULT = 1;
	private static final int UNIVERSITY = 2;
	private static final int COMPANY = 3;
	
	ArrayList<PhoneInfo> info; // ���� ��� �迭
	
	public PhoneBookManager() {
		info = new ArrayList<>(); // �����ڷ� ��ü ���� �� ArrayList�� ����
	}
	
	public void inputInfo(int select) {
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�");
		System.out.println("2. ����");
		System.out.println("3. ȸ��");
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
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("��ȭ��ȣ : ");
			phoneNumber = sc.next();
			sc.nextLine(); // Enter Ű �ޱ�
			if(!checkSameName(name)) {
				info.add(new PhoneInfo(name,phoneNumber));
				System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
			}
			break;
		case UNIVERSITY:
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("��ȭ��ȣ : ");
			phoneNumber = sc.next();
			System.out.print("���� : " );
			major = sc.next();
			System.out.print("�г� : ");
			year = sc.next();
			if(!checkSameName(name)) {
				info.add(new PhoneUnivInfo(name,phoneNumber,major,year));
				System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
			}
			break;
		case COMPANY:
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("��ȭ��ȣ : ");
			phoneNumber = sc.next();
			System.out.print("ȸ��  : ");
			company = sc.next();
			if(!checkSameName(name)) {
				info.add(new PhoneCompanyInfo(name,phoneNumber,company));
				System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
			}
			break;
			}
		} catch (Exception e) {
			System.out.println(select + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�. �޴� ������ ó������ �ٽ� ������ �ֽñ� �ٶ��ϴ�.");
		}
	}
	
	
	/* �츮�� ���������� ���ٰ� ������ ���̹Ƿ� ���������� �����Ͱ� �����ϴ��� �˻� */
	public boolean checkSameName(String name) {
		Iterator<PhoneInfo> itr = info.iterator();
		while(itr.hasNext()) {
			PhoneInfo tmp = itr.next();
			if(tmp.getName().equals(name)) {
				System.out.println("�̸��� ���� ����� �̹� �ֽ��ϴ�.");
				return true;
			}
		}
		return false;
	}
	
	/* �������� �˻� */
	public boolean searchInfo(String name) {
		int i = 0;
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)){
				if(info.get(i) instanceof PhoneCompanyInfo) {
					System.out.println("=======================================" + "\n"
							+ "�̸� : " + info.get(i).getName() + "\n"
							+ "��ȭ��ȣ : " + info.get(i).getPhoneNumber() + "\n"
							+ "ȸ�� : " + ((PhoneCompanyInfo) info.get(i)).getCompany() + "\n"
							+ "=======================================" + "\n");
				}
				else if (info.get(i) instanceof PhoneUnivInfo) {
					System.out.println("=======================================" + "\n"
							+ "�̸� : " + info.get(i).getName() + "\n"
							+ "��ȭ��ȣ : " + info.get(i).getPhoneNumber() + "\n"
							+ "���� : " + ((PhoneUnivInfo) info.get(i)).getMajor() + "\n"
							+ "�г� : " + ((PhoneUnivInfo) info.get(i)).getYear() + "\n"
							+ "=======================================" + "\n");
				}
				else {
					System.out.println("=======================================" + "\n"
							+ "�̸� : " + info.get(i).getName() + "\n"
							+ "��ȭ��ȣ : " + info.get(i).getPhoneNumber() + "\n"
							+ "=======================================" + "\n");
				}
				return true;
			}
		}
		if(i >= info.size()) {
			System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
			return false;
		}
		return false;
	}
	
	/* �������� ���� */
	public void deleteInfo(String name) {
		int i = 0;
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)) {
				info.remove(i);
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
				return;
			}
		}
		if(i >= info.size())
			System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
	}
	
	/* ������ ���� */
	public void modifyInfo(String name) throws IndexOutOfBoundsException {
		// ���� �� ���� �ش� �����Ͱ� �ִ��� �̸����� �˻�
		int i = 0;
		Scanner sc = new Scanner(System.in);
		// ���� ó�� ���� ���� �� ��
		for(i = 0; i < info.size(); i++) {
			if(info.get(i).getName().equals(name)) // ��ġ�ϴ� �̸��� ���� ��� �ݺ��� ����
				break;
		}
		
		if(i >= info.size()) {
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
			return;
		}
		
		PhoneInfo tmp = info.get(i); // �� �ݺ������� ���� ���� �ӽ� PhoneInfo ��ü�� ����
		
		String[] newInfo = new String[3]; // ���� 3���� �����ص� ������ �׳� �迭�� ������.
		
		// ������ �����Ͱ� ��ü�� ���� �ְ�, �ϳ� Ȥ�� �� ���� ���� �����Ƿ� ������ ��츦 üũ�� �ش�.
		// ������ ��� true, �������� ���� ��� false
		boolean[] ischecked = new boolean[3];
		int[] input = new int[2];
		Arrays.fill(ischecked, false); // �ʱⰪ�� ���� false�� ����
		System.out.println("������ �����͸� �����ϼ���. �������� ���� �����ʹ� 0���� �����ּ���.");
		//System.out.println("��) ��ȭ��ȣ�� ������� ���� : 0  , ��� ���� : 1 2 3");
		System.out.println("1. �̸�");
		System.out.println("2. ��ȭ��ȣ");
		
		
		for(i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
			if(input[i] > 0)
				ischecked[i + 1] = true;
		}
		
		for(i = 1; i < ischecked.length; i++) {
			if(ischecked[i] && i == 1) {
				System.out.print("������ �̸� �Է� : ");
				newInfo[0] = sc.next();
				tmp.setName(newInfo[0]);
			}else if(ischecked[i] && i == 2) {
				System.out.print("������ ��ȭ��ȣ �Է� : ");
				newInfo[1] = sc.next();
				tmp.setPhoneNumber(newInfo[1]);
			}
		}
	}
	
	/* ������ ���� ��� */
	public void showPhoneInfo() {
		Iterator<PhoneInfo> itr = info.iterator();
		if(info.isEmpty()) {
			System.out.println("����Ǿ� �ִ� �����Ͱ� �����ϴ�.");
			return;
		}
		while(itr.hasNext()) {
			PhoneInfo tmp = itr.next();
			if(tmp instanceof PhoneUnivInfo) {
				System.out.println("=======================================" + "\n"
						+ "�̸� : " + tmp.getName() + "\n"
						+ "��ȭ��ȣ : " + tmp.getPhoneNumber() + "\n"
						+ "���� : " + ((PhoneUnivInfo)tmp).getMajor() + "\n"
						+ "�г� : " + ((PhoneUnivInfo) tmp).getYear() + "\n"
						+ "========================================");
			}
			else if(tmp instanceof PhoneCompanyInfo) {
				System.out.println("=======================================" + "\n"
						+ "�̸� : " + tmp.getName() + "\n"
						+ "��ȭ��ȣ : " + tmp.getPhoneNumber() + "\n"
						+ "ȸ�� : " + ((PhoneCompanyInfo) tmp).getCompany() + "\n"
						+ "========================================");
			}
			else 
				{
				System.out.println("=======================================" + "\n"
						+ "�̸� : " + tmp.getName() + "\n"
						+ "��ȭ��ȣ : " + tmp.getPhoneNumber() + "\n"
						+ "========================================");
				}			
			}
		}
	}
