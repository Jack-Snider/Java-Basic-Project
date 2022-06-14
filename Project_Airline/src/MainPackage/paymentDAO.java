package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

//실질적인 작업이 이루어지는 클래스 (DB연동, CRUD 등...)
public class paymentDAO extends DBConnection {

	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;
	
	// 데이터베이스 연결
	public void accessDB() {
		DBConnection.getConnection();
	}
	
	// 결제 기능
	public void pay() {
		
	}
	
	// 결제유무 반환
	public boolean payCheck() {
		boolean isPayed = false;
		
		return isPayed;
	}
	
	// 결제일자 반환
	public String payDate() {
		
		return "";
	}
	
	
	
}
