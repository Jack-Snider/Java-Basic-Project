package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserView {

	static boolean isLogined = false;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void menuView() {
		
	
		
		/*
		 * 
		 * �α���, ȸ������, �װ���ȸ, �װ�����,(�̽��Ϳ��� : ����ĳ��) ,ȸ����������
		 * ȸ��Ż��
		 * 
		 * 
		 */
		
		System.out.println();
		System.out.println("-----------��ɾ�-----------");
		System.out.println("login(�α���)");
		System.out.println("signin(ȸ������)");
		System.out.println("srhair(�װ���ȸ)");
		System.out.println("bkair(�װ�����)");
		System.out.println();
		System.out.print(MemberDAO.user_name + " >> ");
		
		try {
			
			String input = bf.readLine();

			
			
			if(input.equalsIgnoreCase("login")) { // �α��� ��� 
				if(!isLogined) {
					MemberDAO mDAO = new MemberDAO();
					mDAO.accessDB();
					
					System.out.print("ID : ");
					String id = bf.readLine();
					System.out.print("PW : ");
					String pw = bf.readLine();
					
					isLogined = MemberDAO.logIn(id, pw);
					
					
					
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
					System.out.println("�̹� �α��� ���ֽ��ϴ�.");
				}
				
				
			} // �α��� ���
			
			
			
			if(input.equalsIgnoreCase("signin"){
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
