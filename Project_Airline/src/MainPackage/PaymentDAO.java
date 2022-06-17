package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

//실질적인 작업이 이루어지는 클래스 (DB연동, CRUD 등...)
public class PaymentDAO extends DBConnection {

	// 외부에서 생성자를 호출하지 못하게 막음(싱글톤으로 운영할 예정)
	private PaymentDAO() {
	}

	// 앞으로 외부에서 사용할 유일한 PaymentDAO 객체(싱글톤)
	private static PaymentDAO payment = new PaymentDAO();

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;

	// 데이터베이스 연결
	public void accessDB() {
		DBConnection.getConnection();
	}

	// PaymentDAO의 객체를 리턴 (다른 클래스에서 이 클래스로 객체를 받아 쓸 예정)
	public static PaymentDAO getPaymentDAO_Instance() {
		
		return payment;

	}

// utils methods by here
//----------------------------------------------------------------------	
	
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
