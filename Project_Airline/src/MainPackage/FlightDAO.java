package MainPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 항공 관련 클래스
public class FlightDAO {

	
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	

	public FlightDAO() {
		conn = DBConnection.getConnection();
	}
	
	
	// 항공조회
	public void showList() {

		 String query = "SELECT FLIGHT_NO, AIR_CODE,"
		 		+ "APT_NM, FLIGHT_DEPA, FLIGHT_DEPT,"
		 		+ "FLIGHT_DEP FROM AIRPORT A, FLIGHT F "
		 		+ "WHERE A.APT_AVL = F.APT_AVL";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String flight_no = rs.getString("FLIGHT_NO");
				String air_code = rs.getString("AIR_CODE");
				String apt_nm = rs.getString("APT_NM");
				String flight_depa = rs.getString("FLIGHT_DEPA");
				String flight_dept = rs.getString("FLIGHT_DEPT");
				String flight_dep = rs.getString("FLIGHT_DEP");
				
				
				System.out.println("┌────항공편───────항공사 코드────도착지──────────출발일────────출발 공항────┐");
				System.out.println("│" + flight_no + " \t \t " + air_code + " \t \t \t" + apt_nm + " \t \t " + flight_depa + " " + flight_dept + " \t \t " + "인천공항" );
				
//				System.out.println("항공편 : " + air_code);
//				System.out.println("항공사 코드 : " + apt_nm);
//				System.out.println("도착지  : " + flight_depa);
//				System.out.println("출발일 : " + flight_dept);
//				System.out.println("출발 공항 : " + flight_dep);
				
				
			}
			
		}catch(SQLException sqle) {
			System.out.println("SQL ERROR : " + sqle);
		}catch(Exception e) {
			System.out.println("UNKNOWN ERROR : " + e);
		}
		
		
		
	}

}
