package MainPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// ������ �������� ������ �� �����ڰ� �� ȭ�� + �������� ��� 
public class AdminView extends DBConnection{

	
	public static void menuView() { // �����ڷ� �α��� ������ ó�� ���� ȭ��
		System.out.println("---------������ ����---------");
	}
	
	public static void showAllMember() { // ȸ�� ��ü����
		
		String query = "SELECT * FROM MEMBER";
		
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String mem_id = rs.getString("MEM_ID");
				String mem_pw = rs.getString("MEM_PW");
				String mem_rgon1 = rs.getString("MEM_RGON1");
				String mem_rgon2 = rs.getString("MEM_RGON2");
				String mem_nm = rs.getString("MEM_NM");
				String mem_tel = rs.getString("MEM_TEL");
				String mem_add = rs.getString("MEM_ADD");
				String mem_pp = rs.getString("MEM_PP");
				String mem_depm = rs.getString("MEM_DEPM");
				String mem_ename = rs.getString("MEM_ENAME");
				
				
				System.out.println(mem_id + "\t" + mem_pw + "\t" + mem_rgon1 + "\t" + mem_rgon2 + "\t"
						+ mem_nm + "\t" + mem_tel + "\t" + mem_add + "\t" + mem_pp + "\t" + mem_depm + "\t"
						+ mem_ename);
				
			}
			
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	
	
	
	// �������
	
	
	
	
	
	
	
	
	
	
	
	
	
}
