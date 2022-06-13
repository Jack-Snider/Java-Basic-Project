package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserView {

	static boolean isLogined = false;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void menuView() {
		
	
		
		/*
		 * 
		 * 로그인, 회원가입, 항공조회, 항공예약,(이스터에그 : 코인캐기) ,회원정보수정
		 * 회원탈퇴
		 * 
		 * 
		 */
		
		System.out.println();
		System.out.println("-----------명령어-----------");
		System.out.println("login(로그인)");
		System.out.println("signin(회원가입)");
		System.out.println("srhair(항공조회)");
		System.out.println("bkair(항공예약)");
		System.out.println();
		System.out.print(MemberDAO.user_name + " >> ");
		
		try {
			
			String input = bf.readLine();

			
			
			if(input.equalsIgnoreCase("login")) { // 로그인 기능 
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
						System.out.println(MemberDAO.user_name + "님 방문을 환영합니다.");
						System.out.println("-----------------------------------------");
						menuView();
					}else {
						System.out.println("로그인 실패"); 
						menuView();
					}
				}else {
					System.out.println("이미 로그인 되있습니다.");
				}
				
				
			} // 로그인 기능
			
			
			
			if(input.equalsIgnoreCase("signin"){
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
