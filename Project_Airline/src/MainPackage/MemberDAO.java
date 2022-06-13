package MainPackage;

// Referenced Link : https://flatsun.tistory.com/385

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class MemberDAO extends DBConnection{
	
	/*
	 * 
	 * -���(Functions)-
	 * 1. ȸ������(SignIn)
	 * 2. �α���(LogIn) , �α׾ƿ�(Logout)
	 * 3. ȸ��Ż��(delAccount)
	 * 4. ���ų��� Ȯ��(checkReserve)
	 * 5. ���ų��� ����(updateReserve)
	 * 6. ����������(updateInfo)
	 * 7. �װ��Ǽ���(pickFlight)
	 * 8. �װ��ǰ���(payFlight)
	 * 
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;
	MemberDTO memDTO;
	
	// ���� DB�� ����.
	public void accessDB() {
		conn = DBConnection.getConnection();
	}
	
	// ȸ��Ż�� - Delete Account
	public void delAccount() {
		
		// logined check first
		
		
	}
	
	// �α���
	public boolean logIn(String id, String pw) {
		// This method returns true for login success
		
		boolean isLogined = false; // <- login status
		
		String query =	"SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + id 
									+ "\'" + " AND " + "MEM_PASS = " + "\'" + pw + "\'";
		
		
		try {
			
			Statement stmt = conn.createStatement();
			//stmt.executeQuery(query);
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				// ����ڰ� �Է��� ���̵�� ����� �����ͺ��̽����� ��ġ�ϴ°� ����
				
				isLogined = true;
				
			}else {
				System.out.println("���̵�/��й�ȣ�� ��ġ���� �ʰų� ���Ե� ȸ���� �ƴմϴ�.");
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isLogined;
	}
	
	
	// ȸ������
	public void signIn() {
		/*
		 * ����� ȸ������ �޼ҵ�
		 * ����ڰ� �Է��ؾ� �� ����
		 * 1. ȸ�����̵� (�ߺ��˻� �ǽ�)
		 * 2. ��й�ȣ
		 * 3. ��й�ȣ Ȯ�� (Ʋ���� ó������ ���ư�) -> ����
		 * 4. �ֹι�ȣ (��, �� �����ؼ� ���������� �ڸ�����)
		 * 5. �̸�
		 * 
		 * 
		 * 
		 */
		try {
			
			Statement stmt = conn.createStatement();
			
			
			System.out.println("�޴��� ���ư��� : m , �ڷΰ��� : < ");
			while(true) { // while starts
				System.out.print("����� ���̵� �Է� : ");
				String id = bf.readLine();
				System.out.print("��й�ȣ �Է� : ");
				String pw = bf.readLine();
				System.out.print("�ֹι�ȣ(���ڸ�-���ڸ�) : ");
				String regon = bf.readLine();
				
				
				// ���̺��� ���� ��������� �ʾ����Ƿ� ���� ���鿹��, ������ �ٸ� DB���� �׽�Ʈ��.
				stmt.executeQuery("SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + id + "\'");
				ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + id + "\'");
							
				//�Էµ� ���̵�� ��ȸ�� �ȴٸ�(rs�� ���� ���ִٸ�)
				if(rs.next()) {
					System.out.println("�ش� ���̵�� �̹� �����ϴ� ���̵��Դϴ�.");
					continue;
				}else {
					System.out.println("��밡���� ���̵��Դϴ�.");
					
					// MemberDAO �ʵ� �ʱ�ȭ
					memDTO = new memDTO();
					
					
					System.out.println("Insert �� �����ͺ��̽��� ����"); // <- DB �ϼ��Ǹ� INSERT ������ �ۼ� ����
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
			
			while(rs.next()) { // ResultSet�� ���� ���� ���� ������ ���
				String mem_id = rs.getString("MEM_ID");
				String mem_name = rs.getString("MEM_NAME");
				
				System.out.println("ID : " + mem_id + " , " + "Name : " + mem_name);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
