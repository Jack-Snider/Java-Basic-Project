package MainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null; // DB�� ����� ����(����)�� ���� ��ü
		PreparedStatement pstm = null; // SQL���� ��Ÿ���� ��ü
		ResultSet rs = null; // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
	
		
		String query = "SELECT * FROM MEMBER";
		
		try {
			
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
		}catch(SQLException sqle) {
			System.out.println("SQL Error : " + sqle);
		}
		
		
		
		
	}

}
