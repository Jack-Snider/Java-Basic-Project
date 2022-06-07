package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Control {
	/*
	 * user : ddit
	 * pw : java
	 * 
	 */
	
	public static Connection dbConn;
	
	// DB 연결 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			String user = "choi"; // DB 계정 아이디 입력
			String pw = "java"; // DB 계정 비밀번호 입력
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			/*
			 * url 
			 * 
			 * jdbc:oracle:thin -> 오라클에 접속하겠다고 알림
			 * @localhost: -> 자신의 포트번호
			 * 1521 : 오라클 포트번호
			 * xe -> 계정의 SID
			 * 
			 * 
			 */
			
			//Java.lang 패키지
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw);
			
			System.out.println("Database에 연결되었습니다.");
				
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
		}catch(SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
		}catch(Exception e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		}
		
		dbConn = conn;
		return dbConn;
		
	}
	
	
	
	/*
	 * 
	 * 기본적인 CRUD 메소드
	 * CREATE
	 * READ(SELECT)
	 * UPDATE
	 * DELETE
	 * 
	 */
	
	public static void create(String target, String name, Object ... values) {
		
		
		
	}
	
	public static void select(String table,  String where , Object ... values) {
		

	
	}
	
	public static void update() {
		
	}
	
	public static void delete() {
		
	}
	
	
	
	
	
	
	
	
	
	
}

