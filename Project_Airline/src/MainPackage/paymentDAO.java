package MainPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class paymentDAO extends DBConnection {

	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;
	
	// �����ͺ��̽� ����
	public void accessDB() {
		DBConnection.getConnection();
	}
	
	// ���� ���
	public void pay() {
		
	}
	
	// �������� ��ȯ
	public boolean payCheck() {
		boolean isPayed = false;
		
		return isPayed;
	}
	
	// �������� ��ȯ
	public String payDate() {
		
		return "";
	}
	
	
	
}
