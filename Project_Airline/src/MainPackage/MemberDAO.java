package MainPackage;

// Referenced Link : https://flatsun.tistory.com/385

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//실질적인 작업이 이루어지는 클래스 (DB연동, CRUD 등...)
public class MemberDAO extends DBConnection{
	
	/*
	 * 
	 * -기능(Functions)-
	 * 1. 회원가입(SignIn)
	 * 2. 로그인(LogIn)
	 * 3. 회원탈퇴(DeleteAcnt)
	 * 4. 예매내역 확인(CheckReserve)
	 * 5. 예매내역 수정(UpdateReserve)
	 * 6. 내정보수정(UpdateInfo)
	 * 7. 항공권선택(PickFlight)
	 * 8. 항공권결제(PayFlight)
	 * 
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;
	
	// 먼저 DB에 연동한다.
	public void accessDB() {
		conn = DBConnection.getConnection();
	}
	
	public void logIn() {
		
	}
	
	
	// 회원가입
	public void signIn() {
		/*
		 * 사용자 회원가입 메소드
		 * 사용자가 입력해야 할 정보
		 * 1. 회원아이디 (중복검사 실시)
		 * 2. 비밀번호
		 * 3. 비밀번호 확인 (틀리면 처음으로 돌아감) -> 보류
		 * 4. 주민번호 (앞, 뒤 구분해서 내부적으론 자를거임)
		 * 5. 이름
		 * 
		 * 
		 * 
		 */
		try {
			
			Statement stmt = conn.createStatement();
			
			
			System.out.println("메뉴로 돌아가기 : m , 뒤로가기 : < ");
			while(true) { // while starts
				System.out.print("사용할 아이디 입력 : ");
				String id = bf.readLine();
				System.out.print("비밀번호 입력 : ");
				String pw = bf.readLine();
				System.out.print("주민번호(앞자리-뒷자리) : ");
				String regon = bf.readLine();
				
				
				// 테이블은 아직 만들어지지 않았으므로 추후 만들예정, 지금은 다른 DB에서 테스트중.
				stmt.executeQuery("SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + id + "\'");
				ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + id + "\'");
							
				//입력된 아이디로 조회가 된다면(rs에 값이 들어가있다면)
				if(rs.next()) {
					System.out.println("해당 아이디는 이미 존재하는 아이디입니다.");
					continue;
				}else {
					System.out.println("사용가능한 아이디입니다.");
					System.out.println("Insert 로 데이터베이스에 저장"); // <- DB 완성되면 INSERT 쿼리문 작성 예정
					break;
				}
			} // while ends
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void select(String query) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) { // ResultSet에 다음 값이 없을 때까지 출력
				String mem_id = rs.getString("MEM_ID");
				String mem_name = rs.getString("MEM_NAME");
				
				System.out.println("ID : " + mem_id + " , " + "Name : " + mem_name);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
