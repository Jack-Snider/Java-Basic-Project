package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemberView {

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
		System.out.println(" Command words");
		System.out.println("┌──────────────┐");
		System.out.println("│login(로그인) \t\t\t      │");
		System.out.println("│logout(로그아웃)\t\t\t      │");
		System.out.println("│signin(회원가입)\t\t\t      │");
		System.out.println("│srhair(항공조회)\t\t\t      │");
		System.out.println("│bkair(항공예약)\t\t\t      │");
		System.out.println("└──────────────┘");
		System.out.println();
		System.out.print(MemberDAO.user_name + " >> ");
		
		try {
			
			String input = bf.readLine();

			
			
			if(input.equalsIgnoreCase("login")) { // 로그인 기능 
				if(!isLogined) {
					MemberDAO.accessDB();
					
					System.out.print("ID : ");
					String id = bf.readLine();
					System.out.print("PW : ");
					String pw = bf.readLine();
					
					isLogined = MemberDAO.logIn(id, pw);
					System.out.println("isLogined : " + isLogined);
					
					
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
					System.out.println("WARNING : 이미 로그인 되있습니다.");
					menuView();
				}
				
				
			} // 로그인 기능 끝
			
			
			
			else if(input.equalsIgnoreCase("signin")){ // 회원가입 기능 시작
				MemberDAO.accessDB();
				if(isLogined) {
					System.out.println();
					System.out.println("WARNING : 회원가입을 하시려면 먼저 로그아웃을 하셔야 합니다.");
					menuView();
				}else {
					MemberDAO.signIn();
					menuView();
				}
				
				
			} // 회원가입 기능 끝
			
			
			else if(input.equalsIgnoreCase("logout")) { // 로그아웃 기능 시작
				
				if(isLogined) { // 로그인이 되어있는 상태
					
					MemberDAO.user_name = "";
					System.out.println();
					System.out.println("SUCCESS : 정상적으로 로그아웃 하셨습니다.");
					menuView();
					
				}else { // 로그인이 되어있지 않은 상태
					System.out.println();
					System.out.println("WARNING : 현재 로그인 되어있지 않습니다. 다시 확인해주세요.");
					menuView();
				}
				
			}// 로그아웃 기능 끝
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
