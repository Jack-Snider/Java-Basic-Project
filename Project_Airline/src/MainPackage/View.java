package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 사용자에게 보여질 화면들을 정의 해놓은 클래스
public class View {

	static boolean isLogined = false; // 회원의 로그인 상태 (로그인 : true, 로그아웃 : false)
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // Scanner의 기능
	
	// 사용자가 처음 로그인 했을때와 앞으로 보여질 화면
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
		System.out.println("│update(회원수정)\t\t      │");	
		System.out.println("│delete(회원탈퇴)\t\t\t      │");
		System.out.println("│signin(회원가입)\t\t\t      │");
		System.out.println("│srhair(항공조회)\t\t\t      │");
		System.out.println("│bkair(항공예약)\t\t\t      │");
		System.out.println("└──────────────┘");
		System.out.println();
		System.out.print(MemberDAO.user_name + " >> ");
		
		try {
			
			String input = bf.readLine();

			
//-------------------------------------------------------------------------------			
			
			// 로그인
			if(input.equalsIgnoreCase("login")) { // 로그인 기능 
				if(!isLogined) {
					MemberDAO.accessDB(); // 데이터베이스 연동 (MemberDAO 클래스의 accessDB() 메소드 호출
					
					System.out.print("ID : ");
					String id = bf.readLine();
					System.out.print("PW : ");
					String pw = bf.readLine();
					
					isLogined = MemberDAO.logIn(id, pw); // 로그인 하는 함수, MemberDAO 클래스의 login()메소드를 호출
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
			
//-------------------------------------------------------------------------------			
			
			// 회원가입
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

//-------------------------------------------------------------------------------
			
			// 로그아웃
			else if(input.equalsIgnoreCase("logout")) { // 로그아웃 기능 시작
				
				if(isLogined) { // 로그인이 되어있는 상태
					
					MemberDAO.user_name = "";
					System.out.println();
					System.out.println("SUCCESS : 정상적으로 로그아웃 하셨습니다.");
					isLogined = false;
					menuView();
					
				}else { // 로그인이 되어있지 않은 상태
					System.out.println();
					System.out.println("WARNING : 현재 로그인 되어있지 않습니다. 다시 확인해주세요.");
					menuView();
				}
				
			}// 로그아웃 기능 끝
//-------------------------------------------------------------------------------
			
			
			//회원탈퇴
			else if(input.equalsIgnoreCase("delete")) { // 회원탈퇴 시작
				if(isLogined) {
					String tmp = "";
					System.out.print("정말로 회원탈퇴를 하실겁니까?(YES/NO) >> ");
					tmp = bf.readLine();
					if(tmp.equalsIgnoreCase("YES")) {
						System.out.println("다음과 같은 문구를 작성해주세요..");
						System.out.println("'" + MemberDAO.user_id + " is free'");
						System.out.print(MemberDAO.user_id + " >> ");
						tmp = bf.readLine();
						if(tmp.equals(MemberDAO.user_id + " is free")) {
							MemberDAO.deleteAccount();
							isLogined = false;
							System.out.println("정상적으로 탈퇴 하셨습니다.. 다음에 또 오시길..");
							menuView();
							
						}else {
							System.out.println("WARNING : 잘못 입력하셨습니다.");
							menuView();
						}
						//System.out.println(user_id );
					}else {
						menuView();
						System.out.println("조금 더 생각하고 와주세요.. ㅜㅜ");
					}
					
					
					menuView();
				}else {
					System.out.println("WARNING : 먼저 로그인을 해주세요.");
					menuView();
				}
			}// 회원탈퇴 끝
			
			
//-------------------------------------------------------------------------------
			
			// 회원정보 수정
			else if(input.equalsIgnoreCase("update")) { // 회원정보 수정 시작
				if(isLogined) {
					
					MemberDAO.update();				
					
				}else {
					System.out.println("WARNING : 로그인을 먼저 하셔야 합니다.");
					menuView();
				}
			} // 회원정보 수정 끝
			
			
			
			else if(input.equals("1004")) {
					new AdminView().menuView();
			}
			
			
		// try	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
