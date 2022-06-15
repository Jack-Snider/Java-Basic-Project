package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ����ڿ��� ������ ȭ����� ���� �س��� Ŭ����
public class View {

	static boolean isLogined = false; // ȸ���� �α��� ���� (�α��� : true, �α׾ƿ� : false)
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // Scanner�� ���
	
	public static void menuView() {
		
	
		
		/*
		 * 
		 * �α���, ȸ������, �װ���ȸ, �װ�����,(�̽��Ϳ��� : ����ĳ��) ,ȸ����������
		 * ȸ��Ż��
		 * 
		 * 
		 */
		
		System.out.println();
		System.out.println(" Command words");
		System.out.println("��������������������������������");
		System.out.println("��login(�α���) \t\t\t      ��");
		System.out.println("��logout(�α׾ƿ�)\t\t\t      ��");
		System.out.println("��update(ȸ������)\t\t      ��");	
		System.out.println("��delete(ȸ��Ż��)\t\t\t      ��");
		System.out.println("��signin(ȸ������)\t\t\t      ��");
		System.out.println("��srhair(�װ���ȸ)\t\t\t      ��");
		System.out.println("��bkair(�װ�����)\t\t\t      ��");
		System.out.println("��������������������������������");
		System.out.println();
		System.out.print(MemberDAO.user_name + " >> ");
		
		try {
			
			String input = bf.readLine();

			
			
			if(input.equalsIgnoreCase("login")) { // �α��� ��� 
				if(!isLogined) {
					MemberDAO.accessDB();
					
					System.out.print("ID : ");
					String id = bf.readLine();
					System.out.print("PW : ");
					String pw = bf.readLine();
					
					isLogined = MemberDAO.logIn(id, pw); // �α��� �ϴ� �Լ�, MemberDAO Ŭ������ login()�޼ҵ带 ȣ��
					System.out.println("isLogined : " + isLogined);
					
					
					if(isLogined) {
						System.out.println("-----------------------------------------");
						System.out.println(MemberDAO.user_name + "�� �湮�� ȯ���մϴ�.");
						System.out.println("-----------------------------------------");
						menuView();
					}else {
						System.out.println("�α��� ����"); 
						menuView();
					}
				}else {
					System.out.println("WARNING : �̹� �α��� ���ֽ��ϴ�.");
					menuView();
				}
				
				
			} // �α��� ��� ��
			
			
			
			else if(input.equalsIgnoreCase("signin")){ // ȸ������ ��� ����
				MemberDAO.accessDB();
				if(isLogined) {
					System.out.println();
					System.out.println("WARNING : ȸ�������� �Ͻ÷��� ���� �α׾ƿ��� �ϼž� �մϴ�.");
					menuView();
				}else {
					MemberDAO.signIn();
					menuView();
				}
				
				
			} // ȸ������ ��� ��
			
			
			else if(input.equalsIgnoreCase("logout")) { // �α׾ƿ� ��� ����
				
				if(isLogined) { // �α����� �Ǿ��ִ� ����
					
					MemberDAO.user_name = "";
					System.out.println();
					System.out.println("SUCCESS : ���������� �α׾ƿ� �ϼ̽��ϴ�.");
					isLogined = false;
					menuView();
					
				}else { // �α����� �Ǿ����� ���� ����
					System.out.println();
					System.out.println("WARNING : ���� �α��� �Ǿ����� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���.");
					menuView();
				}
				
			}// �α׾ƿ� ��� ��
			
			//ȸ��Ż��
			else if(input.equalsIgnoreCase("delete")) { // ȸ��Ż�� ����
				if(isLogined) {
					String tmp = "";
					System.out.print("������ ȸ��Ż�� �Ͻǰ̴ϱ�?(YES/NO) >> ");
					tmp = bf.readLine();
					if(tmp.equalsIgnoreCase("YES")) {
						System.out.println("������ ���� ������ �ۼ����ּ���..");
						System.out.println("'" + MemberDAO.user_id + " is free'");
						System.out.print(MemberDAO.user_id + " >> ");
						tmp = bf.readLine();
						if(tmp.equals(MemberDAO.user_id + " is free")) {
							MemberDAO.deleteAccount();
							isLogined = false;
							System.out.println("���������� Ż�� �ϼ̽��ϴ�.. ������ �� ���ñ�..");
							menuView();
							
						}else {
							System.out.println("WARNING : �߸� �Է��ϼ̽��ϴ�.");
							menuView();
						}
						//System.out.println(user_id );
					}else {
						menuView();
						System.out.println("���� �� �����ϰ� ���ּ���.. �̤�");
					}
					
					
					menuView();
				}else {
					System.out.println("WARNING : ���� �α����� ���ּ���.");
					menuView();
				}
			}// ȸ��Ż�� ��
			
			else if(input.equalsIgnoreCase("update")) {
				if(isLogined) {
					MemberDAO.update();
					
					
				}else {
					System.out.println("WARNING : �α����� ���� �ϼž� �մϴ�.");
					menuView();
				}
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
